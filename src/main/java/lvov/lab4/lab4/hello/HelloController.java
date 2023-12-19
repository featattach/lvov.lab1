package lvov.lab4.lab4.hello;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class HelloController {

    private List<String> stringList = new ArrayList<>();
    private Map<Integer, String> integerStringMap = new HashMap<>();

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);

    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        if (stringList.isEmpty()) {
            // Если список пустой, создаем новый
            stringList = new ArrayList<>();
        }

        // Добавляем значение в список
        stringList.add(s);

        // Возвращаем информацию о том, что значение добавлено
        return String.format("Value '%s' added to the list. Current list: %s", s, stringList);
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return stringList;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        if (integerStringMap.isEmpty()) {
            integerStringMap = new HashMap<>();
        }

        // Генерируем уникальный ключ (может быть реализовано по-другому в зависимости от требований)
        int key = integerStringMap.size() + 1;

        // Записываем значение в HashMap
        integerStringMap.put(key, s);

        return String.format("Value '%s' added to the map with key %d. Current map: %s", s, key, integerStringMap);

    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        return integerStringMap;
    }
    @GetMapping("/show-all-length")
    public String showAllLength() {
        int arrayListLength = stringList.size();
        int hashMapLength = integerStringMap.size();

        return String.format("ArrayList length: %d, HashMap length: %d", arrayListLength, hashMapLength);
    }
}



