import java.io.*;
import java.util.*;
import java.util.regex.*;


/**
 * Created by Samsung on 30.12.2017.
 */

public class Main {



    static boolean isWordInArguments(String s, List<String> arguments)
    {
        for(String argument:arguments)
        {
            try {// блок try для вылавливания невалидных регулярных выражений
                if (s.matches(argument))
                    return true;
            }
            catch (PatternSyntaxException e)//если регул. вырожение невалидное
            {
                if(s.equals(argument)) //сравниваем слово с а аргументом
                    return true;
            }
        }
        return false;


    }

    public static void main(String[] args) throws FileNotFoundException,IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите параметры:");
        List<String> arguments=new ArrayList<>();
        for(String s:in.nextLine().split(" "))// создание списка параметров
        {
            arguments.add(s);
        }


        List<String> text=new ArrayList<>();

        System.out.println("Введите текст:");//ввод текста
        while(true)
        {
            String temp= in.nextLine();
            if(temp.equals(""))    //если пустая строка то прекращаем ввод
                break;
            text.add(temp);
        }

        if(arguments.size()==1&&arguments.get(0).equals("")) //если аргументов нет то выводим все строки
        {
            System.out.println("Результат");
            for(String line:text) {
                System.out.println(line);
            }
            System.exit(0);
        }
        List<String> filteredText=new ArrayList<>();


        for(String line:text) //фильтрация строк
        {
            for(String word:line.split(" "))//разьбираем стоку по словам
            {
                if(isWordInArguments(word,arguments))// если слово есть в списке пораметров
                {
                    filteredText.add(line);
                    break;
                }
            }
        }

        System.out.println("Результат");
        for(String line:filteredText) {
            System.out.println(line);
        }
    }
}
