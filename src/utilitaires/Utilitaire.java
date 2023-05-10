package utilitaires;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Utilitaire {
    private static Scanner sc = new Scanner(System.in);
    private static String errMSG="  veuillez introduire à nouveau le champs car valeur incorrecte";
    public static int choixListe(List l)
    {

        int i =1;
        for(Object o :l)
        {
            System.out.println((i++)+"."+o);
        }

        int choix;
        do
        {
            System.out.println("choix :");
            try
            {

                choix = sc.nextInt();
                sc.skip("\n");
            }
            catch (Exception e)
            {
                sc=new Scanner(System.in);
                System.out.println(e.toString()+errMSG);
                return choixListe(l);
            }

        } while(choix <1 || choix > l.size());

        return choix;
    }
    public static void affListe(List l)
    {
        int i =1;
        for(Object o :l) {
            System.out.println((i++)+"."+o);
        }
    }
    public static LocalDate lecDate()
    {
        try
        {
            String[] jma = sc.nextLine().split(" ");
            int j = Integer.parseInt(jma[0]);
            int m = Integer.parseInt(jma[1]);
            int a = Integer.parseInt(jma[2]);
            return LocalDate.of(a,m,j);
        }catch (Exception e)
        {
            System.out.println(e.toString()+errMSG);
            sc=new Scanner(System.in);
            return lecDate();
        }



    }

    public static LocalTime lecTime()
    {
        try
        {
            String[] hms = sc.nextLine().split(" ");
            int h = Integer.parseInt(hms[0]);
            int m = Integer.parseInt(hms[1]);
            int s = Integer.parseInt(hms[2]);
            return LocalTime.of(h,m,s);
        }catch (Exception e)
        {
            System.out.println(e.toString()+errMSG);
            sc=new Scanner(System.in);
            return lecTime();
        }
    }
    public static String getDateFrench(LocalDate d)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d MM yyyy");
        return dtf.format(d);
    }

    public static String modifyIfNotBlank(String label,String oldValue)
    {
        System.out.println(label+" : "+oldValue);
        System.out.print("nouvelle valeur (enter si pas de changement) : ");
        try
        {
            String newValue= sc.nextLine();
            if(newValue.isBlank()) return oldValue;
            if(newValue.matches(".*[0-9].*"))
            {
                System.out.println("mauvais encodage, veuillez reéssayer car vous avez utilisez des nombres.");
                return modifyIfNotBlank(label,oldValue);
            }
            return newValue;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return modifyIfNotBlank(label,oldValue);
        }
    }
    public static String CreateString(String label)
    {
        System.out.println(label);
        try
        {
            String newValue= sc.nextLine();
            return newValue;
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return CreateString(label);
        }
    }
    public static String CreateStringName(String label)
    {
        System.out.println(label);
        try
        {
            String newValue= sc.nextLine();
            if(newValue.matches(".*[0-9].*"))
            {
                System.out.println("mauvais encodage, veuillez reéssayer car vous avez utilisez des nombres.");
                return CreateStringName(label);
            }
            return newValue;
        }
        catch (Exception e)
        {
            System.out.println(e.toString()+errMSG);
            return CreateStringName(label);
        }
    }
    public static int choixElt(List l)
    {
        int choix;
        try {
                do
                {
                    System.out.println("choix :");
                    choix = sc.nextInt();
                    sc.skip("\n");
                }
                while(choix <1 || choix > l.size());
                    return choix;
            }catch (Exception e)
            {
                System.out.println(e.toString());

                return choixElt(l);
            }

    }

    public static int lireInt(){
        int n=0;
        do{
            try {
                String ns = sc.nextLine();
                n=Integer.parseInt(ns);
                return n;
            }
            catch(NumberFormatException e){
                System.out.println("valeur numérique incorrecte");
            }

        } while(true);
    }
}