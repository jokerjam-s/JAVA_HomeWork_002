/*
    Дан массив строк

    ```json
    [
        {"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
        {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
        {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}
    ]
    ```

    Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: <br>
    Студент [фамилия] получил [оценка] по предмету [предмет].

    **Пример вывода:**

    Студент Иванов получил 5 по предмету Математика.<br>
    Студент Петрова получил 4 по предмету Информатика.<br>
    Студент Краснов получил 5 по предмету Физика.

    Массив json строк зададим через константный массив
 */

package Task012;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class task012 {

    private static final String[] jsonList = new String[]{
            "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}",
            "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}",
            "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}"};
    private static final Map<String, String> keys = new HashMap<>() {
        {
            put("фамилия", "Студент ");
            put("оценка", "получил ");
            put("предмет", "по предмету ");
        }
    };

    public static void main(String[] args) {
        for (String json : jsonList) {
            System.out.println(getStudentInfo(json));
        }
    }

    // получение информации о студенте
    public static String getStudentInfo(String studentInfo) {
        Gson gson = new Gson();
        Map<String, String> data = new HashMap<String, String>();
        Type jsonMapType = new TypeToken<Map<String, String>>() {
        }.getType();

        data = gson.fromJson(studentInfo, jsonMapType);

        StringBuilder builder = new StringBuilder();
        for (String key : data.keySet()) {
            builder.append(keys.getOrDefault(key, "- "))
                    .append(data.get(key))
                    .append(" ");

        }

        return builder.toString();
    }
}
