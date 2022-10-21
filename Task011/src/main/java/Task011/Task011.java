/*
    Дана строка sql-запроса "select * from students where ".
    Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
    Если значение null, то параметр не должен попадать в запрос.

    Параметры для фильтрации:
    {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

    Строки для построения задидим константами
    Для парсинга JSON используем GSON от Google
 */

package Task011;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Task011 {
    // исходные данные
    public static final String SELECT_STR = "select * from students where ";
    public static final String DATA_WHERE = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";


    public static void main(String[] args) {
        System.out.println(createSql(SELECT_STR, DATA_WHERE));
    }

    // подготовка SQL строки, согласно условий и данных
    public static String createSql(String sql, String whereJson) {
        Gson gson = new Gson();
        Map<String, String> whereData = new HashMap<String, String>();
        Type jsonMapType = new TypeToken<Map<String, String>>() {
        }.getType();

        whereData = gson.fromJson(whereJson, jsonMapType);

        StringBuilder builder = new StringBuilder(sql);
        for (String key : whereData.keySet()) {
            if (!whereData.get(key).equals("null")) {
                builder.append(key).append("='").append(whereData.get(key)).append("' and ");
            }
        }

        return builder.toString().substring(0, builder.length()-5);
    }
}
