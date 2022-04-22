package 文件;

public abstract class Reader_ {
    public void readFile() {
    }

    ;

    public void readString() {
    }

    ;
}

class FileReader_ extends Reader_ {
    public void readFile() {
        System.out.println("读取文件");
    }
}

class StringReader_ extends Reader_ {
    public void readString() {
        System.out.println("读取字符串");
    }
}

class BufferedReader_ extends Reader_ {
    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    public void readFile(){
        reader_.readFile();
    }

    public void readFiles(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readFile();
        }
    }

    public void readString(){
        reader_.readString();
    }

    public void readStrings(int num) {
        for (int i = 0; i < num; i++) {
            reader_.readString();
        }
    }
}
