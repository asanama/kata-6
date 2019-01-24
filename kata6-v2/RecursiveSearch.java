package kata6;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RecursiveSearch {
    Map<Integer, Integer> map;
    List<File> fileList;

    public Map recursiveSearchByProf(int prof, Map<Integer, Integer> map){
        this.map = map;
        File file = new File("/");

        fileList = new ArrayList<File>();

        recursiveMethod(file, prof);
        Iterator iterator = fileList.iterator();

        while(iterator.hasNext()){
            File f = (File) iterator.next();
            Long l = f.length();
            Integer integer =  (int) (l / (1024*1024));

            map.put(integer, map.containsKey(integer) ? map.get(integer) + 1 : 1);
        }
        return map;
    }

    private void recursiveMethod(File file, int prof){
        if(prof > 0){
            File[] files = file.listFiles();
            if(files != null){
                    Arrays.asList(files).forEach((fileR)->{
                            fileList.add(fileR);
                            recursiveMethod(fileR, prof-1);
                    });
            }
        }
    }
}
