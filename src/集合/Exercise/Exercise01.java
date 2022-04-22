package 集合.Exercise;

import com.sun.javaws.IconUtil;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings({"all"})
public class Exercise01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        for (int i = arrayList.size()-1; i >= 0; i--) {
            News news = (News)arrayList.get(i);
            System.out.println(processTitle(news.getTitle()));
        }

    }
    public static String processTitle(String title){
        if (title == null)
            return "";
        if (title.length()>15)
            return title.substring(0, 15) + "...'";
        else
            return title;
    }
}

class News {
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title='" + title;
    }
}
