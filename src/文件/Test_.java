package 文件;

public class Test_ {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFile();
//        bufferedReader_.readFiles(10);
        BufferedReader_ bufferedReader_1 = new BufferedReader_(new StringReader_());
        bufferedReader_1.readString();
//        bufferedReader_1.readStrings(10);
    }
}
