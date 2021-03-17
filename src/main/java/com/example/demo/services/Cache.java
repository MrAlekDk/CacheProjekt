package com.example.demo.services;

import com.example.demo.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class Cache {

    private Map<Integer, String> map;
    private Map<Integer, Integer> ttl;

    public Cache() {
        this.map = new HashMap();
        this.ttl = new TreeMap();
    }

    public String get(int key) throws InterruptedException {
        return map.get(key);
    }

    public void set(int key, String value) {
        map.put(key, value);
    }

    public boolean has(int key) {
        if (map.containsKey(key)) {
            return true;
        } else {
            return false;
        }
    }

    public void delete(int key) {
        map.remove(key);
    }

    public void setTTL(int key, int seconds) {
        TimeUnit ttlUnit = TimeUnit.SECONDS;
        //ttlUnit.convert();
            ttl.put(key,seconds);

    }

    public void checkTTL() {


}




}
