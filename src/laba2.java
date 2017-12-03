

import java.util.*;

public class laba2 {

    public static ArrayList<Integer> MasSort (ArrayList<Integer> a){
        int j,t;
        for (int i=1;i<a.size();i++){
            j=i-1;
            t=a.get(i);

            while ((j>=0)&&(a.get(j)>t) ) {
                a.set(j + 1, a.get(j));
                j--;
            }
            a.set(j+1,t);
        }

        return a;
    }
    public static ArrayList<Integer> MasSub(ArrayList<Integer>  MassA,ArrayList<Integer>  MassB){
        ArrayList<Integer> MassC=new ArrayList<Integer>();
        int j;
        boolean t;
        for (int i=0;i<MassA.size();i++){
            t =true;
            j=0;
            while ((t)&&(j<MassB.size())){
                if (MassA.get(i)==MassB.get(j)){
                    t=false;
                }
                j++;
            }
            if (t){
                MassC.add(MassA.get(i));

            }
        }

        return MassC;
    }

    public static ArrayList<Integer> MasSum (ArrayList<Integer>  MassA,ArrayList<Integer>  MassB){

        ArrayList<Integer> MassC=new ArrayList<Integer>();
        int j=0;
        boolean t;
        for (int i=0;i<MassA.size();i++){
            MassC.add(MassA.get(i));
        }

        for (int i=0;i<MassB.size();i++){
            j=0;
            t=true;
            while (t && (j<MassA.size()) ) {
                if (MassB.get(i)==MassA.get(j)){
                    t=false;
                }
                j++;
            }
            if (t){
                MassC.add(MassB.get(i));

            }
        }
        return MassC;
    }





    public static void main(String[] args) {
        int n,m;
        byte o;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность множества A");
        n=sc.nextInt();
        System.out.println("Введите размерность множества B");
        m=sc.nextInt();
        ArrayList<Integer> MassA=new ArrayList<Integer>();
        ArrayList<Integer> MassB=new ArrayList<Integer>();
        System.out.println("Введите элементы множества A");
        for (int i=0;i<n;i++){
            MassA.add(sc.nextInt());
        }
        System.out.println("Введите элементы множества B");
        for (int i=0;i<m;i++){
            MassB.add(sc.nextInt());
        }

        System.out.println("Введите номер операции,которую вы бы хотели провести над множествами: 1)Объединение" +
                " 2)пересечение 3)A-B 4)B-A 5)Симметрическая разность");
        o=sc.nextByte();
        int j;
        boolean t;
        ArrayList<Integer>  MassC=new ArrayList<Integer>();
        switch (o) {
            case 1:
                MassC=MasSum(MassA,MassB);
                break;
            case 2:

                for (int i=0;i<MassA.size();i++){
                    t=true;
                    j=0;
                    while ((t)&&(j<MassB.size())){
                        if (MassA.get(i)==MassB.get(j)){
                            t=false;
                        }
                        j++;
                    }
                    if (!t){
                        MassC.add(MassA.get(i));

                    }

                }
                break;
            case 3:
                MassC=MasSub(MassA,MassB);

                break;
            case 4:
                MassC=MasSub(MassB,MassA);
                break;
            case 5:
                MassC=MasSum(MasSub(MassA,MassB),MasSub(MassB,MassA));
                break;

        }
        MasSort(MassC);
        System.out.println("Результат операции");
        for (int i=0;i<MassC.size();i++){
            System.out.print(MassC.get(i)+" ");
        }

    }
}
