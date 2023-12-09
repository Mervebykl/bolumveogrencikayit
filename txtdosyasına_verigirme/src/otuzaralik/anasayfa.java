package otuzaralik;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class anasayfa {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		ArrayList<ogrenci>liste=new ArrayList<ogrenci>();
		String line;
		String[] okunanlar;
		String ad,soyad;
		int no,secim;
		boolean dongu=true;
		int adet;
	try {
		File dosya=new File("ogrenciler.txt");
		if(!dosya.exists()) {
			dosya.createNewFile();
	
}
		FileReader fr = new FileReader(dosya);
		BufferedReader br=new BufferedReader(fr) ;
		while((line=br.readLine())!=null)
{
			
			okunanlar=line.split(" ");
			no=Integer.parseInt(okunanlar[0]);
			ad=okunanlar[1];
			soyad=okunanlar[2];
			liste.add(new ogrenci(no,ad,soyad));
			/*
			 * dizi içine verileri okuma
			 * for(int i=0;i<okunanlar.length;i++) {
				System.out.println(okunanlar[i]);
			}*/
}
		fr.close();
	br.close();
	}
	
	catch (FileNotFoundException e)
{
	
		e.printStackTrace();

}
	catch (IOException e)
{
	
	e.printStackTrace();
}
	while(dongu) {
		System.out.println("secim yapýnýz: ");
		System.out.println("1-ogrenci ekle");
		System.out.println("2-ogrenci listele");
		System.out.println("3-cýkýs");
		secim=scan.nextInt();
				
		switch(secim) {
		case 1:
			System.out.println("eklenecek ogrenci adetini giriniz: ");
			adet=scan.nextInt();
			for(int i=0;i<adet;i++) {
				System.out.println("ogrenci nosunu giriniz: ");
				no=scan.nextInt();
				System.out.println("ogrenci adýný giriniz: ");
				ad=scan.next();
				System.out.println("ogrenci soyadýný giriniz");
				soyad=scan.next();
				liste.add(new ogrenci(no,ad,soyad));
				}
			break;
			
		case 2:
			for(ogrenci ogr:liste) {
				System.out.println("ogrenci no"+ogr.no);
			}
			
			break;
			
		case 3:
			try {
				
				File dosya=new File("ogrenciler.txt");
			if(!dosya.exists()) {
				dosya.createNewFile();
			}
			FileWriter fw=new FileWriter(dosya);
			BufferedWriter bw=new BufferedWriter(fw);
			
			for(ogrenci ogren:liste) {
				bw.write(ogren.no+" "+ogren.ad+" "+ogren.Soyad+" "+"\n");
			}
			/*fw.close();
			bw.close();*/
			}
			catch(IOException e) {
				e.printStackTrace();
				
			}
			dongu=false;
			break;
			default:
				System.out.println("lütfe 1-2-3 dýþýnda sayý seçmeyin!!");
				break;
			}
		}
	}
	
}

