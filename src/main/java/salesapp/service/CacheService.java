package salesapp.service;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class CacheService implements ApplicationListener<ContextRefreshedEvent> {
	private ConcurrentHashMap<String, CacheItem> cache = new ConcurrentHashMap<String, CacheItem>();

	public void set(String key, Object value, int timeout) {
		CacheItem item = new CacheItem();
		item.setData(value);
		if (timeout != 0) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.SECOND, timeout);
			item.setEnd(c.getTime());
		}
		cache.put(key, item);
	}

	public void update(String key, int timeout) {
		Object obj = get(key);
		if (obj != null) {
			set(key, obj, timeout);
		}
	}

	public Object get(String key) {
		if (cache.containsKey(key)) {
			return cache.get(key).getData();
		}
		return null;
	}

	public void remove(String key) {
		cache.remove(key);
	}

	private static class CacheItem {
		private Object data;
		private Date end;

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public Date getEnd() {
			return end;
		}

		public void setEnd(Date end) {
			this.end = end;
		}
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			Thread t = new Thread(() -> {
				for (;;) {
					try {
						Date now = new Date();
						List<String> list = new LinkedList<String>();
						cache.forEach((key, item) -> {
							if (item.getEnd() != null && now.compareTo(item.getEnd()) > 0) {
								list.add(key);
							}
						});
						list.forEach(key -> cache.remove(key));
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			t.setName("clear cache");
			t.start();
		}
	}
}
