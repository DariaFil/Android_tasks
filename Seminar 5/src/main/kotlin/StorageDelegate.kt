package main.kotlin

import kotlin.reflect.KProperty

class StorageDelegate {

    private val map: MutableMap<String, Any?> = mutableMapOf()
    private val key: String = "key"

    operator fun getValue(thisRef: Any?, property: KProperty<*>) : Any? {
        return map[key]
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Any?) {
        map.clear()
        map.put(key, value)
    }
}