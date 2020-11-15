package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class CacheTest {
    public static void main(String[] args) {
        //通过guava构建一个缓存
        Cache<String, String> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(100)//设置缓存的最大容量
                .expireAfterWrite(1, TimeUnit.MINUTES)//一分钟后失效
                .concurrencyLevel(10)//设置并发级别10
                .recordStats()//开启缓存统计
                .build();
        //放入缓存
        cacheBuilder.put("shienlei","123456");
        String value = cacheBuilder.getIfPresent("shienlei");
        System.out.println("----------:"+value);
    }
}
