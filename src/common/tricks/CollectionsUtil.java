package common.tricks;

import java.util.*;

public class CollectionsUtil {
    public static void main(String args[]){

        List data = new ArrayList();
        data.add("21");
        data.add("12");
        Collections.sort(data);
        System.out.println(data);


        List<Laptop> laptops = new ArrayList<Laptop>();
        laptops.add(new Laptop(10, 500 ,""));
        laptops.add(new Laptop(7, 1024,""));
        laptops.add(new Laptop(23, 256,""));
        laptops.add(new Laptop(14, 2048,""));
        laptops.add(new Laptop(4, 300,""));

        Collections.sort(laptops);

        for (Laptop laptop : laptops ) {
            System.out.println(laptop.ram);
        }

        Comparator<Laptop> hardDiskSort = new Comparator<Laptop>() {
            @Override
            public int compare(Laptop laptop1, Laptop laptop2) {
                if(laptop1.getHardDisk() > laptop2.getHardDisk()){
                    return 1;
                } else  {
                    return -1;
                }
            }
        };

        Collections.sort(laptops, hardDiskSort);

        for (Laptop laptop : laptops ) {
            System.out.println(laptop.hardDisk);
        }

    }
}

class Laptop implements Comparable<Laptop>{

    int ram;
    int hardDisk;
    String processor;

    public Laptop(Integer ram, int hardDisk, String processor) {
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.processor = processor;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public int compareTo(Laptop object) {
        if(this.getRam() > object.getRam()){
            return 1;
        } else  {
            return -1;
        }
    }
}
