package kata6;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapCreator {

    public Map<Integer, Integer> getMegabytesMap() {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();

        File file = new File("/");

        Iterator<Integer> iterator = megabytes(lengthsOf(iteratorOf(file.listFiles())));

        while(iterator.hasNext()){
            Integer integer = iterator.next();
            map.put(integer, map.containsKey(integer) ? map.get(integer) + 1 : 1);
        }
        return map;
    }

    public static Iterator<Integer> megabytes(Iterator<Long> iterator){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Integer next() {
                return (int) (iterator.next() / (1024*1024));
            }
        };
    }

    public static Iterator<Long> lengthsOf(Iterator<File> iterator){
        return new Iterator<Long>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Long next() {
                return iterator.next().length();
            }
        };
    }

    public static Iterator<File> iteratorOf(File[] files){
        return new Iterator<File>() {
            private int cont = 0;
            @Override
            public boolean hasNext() {
                return cont < files.length;
            }

            @Override
            public File next() {
                return files[cont++];
            }
        };
    }
}
