package com.pk.brokenenglish;
import java.util.Random;
public class words {
int rand,i,len,num[];

String s[]={"Fire","Apple","Aple","Art","Babbi","Baby","Bakset","Basket","Blel","Bell","Thubm","Bird","Frend","Braed","Loev","Clock","Jupm","Dust","Raod","Fox","Lokc","Fish","Ditry","Green",
		"Kign","King","Quen","Key","Chlid","Child","Mikl","Soup","Yellwo","Sand","Wacth","Watch","Famly","Water","Siwm","Zoo","Tigre","Three","Zreo","Cat","Willage","Dog","Yaer",
		"Time","Pariis","Person","Wrold","Life","Iye","Hand","Wonen","Work","Waek","Case","Circel","Point","Rsoe","Company","Nubmer","Music","Powor","Meat","Idae","Food","Nihgt",
		"Story","Mediia","Safety","Violine","Exam","Vedio","Movie","Movei","Math","Sceince","Camera","Gaol","Truth","Enrgy","Paper","Succes","Role","Ofice","Mood","Flihgt","Drive",
		"Fone","Lake","Blod","Onion","Haert","City","Photu","Google","Drikn","Image","Losss","Virus","Moter","Wallet","Geust","Leader","Giutar","Tennis","Chucrh","Sing","Polise",
		"Temple","Dinnre","Radio","Lucnh","Bonus","Vehicel","Volume","Erorr","Mouth","Vife","Girl","Vinner","Writer","Cokie","Desk","Lader","Honey","Paino","Home","Pottato",
		"Salad","Weding","Sister","Bleu","Money","Shrit","Uncle","Peom","Book","Haet","Cold","Shcool","Tuition","Actoin","Sound","Caost","Sport","Baot","Test","Riveiw","Soil",
		"Scren","Cash","Gfit","Mouse","Monring","Earth","Bakn","Store","Futur","Gandhi","Sterss","Mobile","Presure","Cycle","Piant","Metal","Oferr","Egg","Squre","Card","Vioce",
		"Brush","Eixt","Back","Cuople","Plant","Trakc","Tree"};
public int[] insert()
{
len = s.length-1;
num = new int[len];
for(i=0;i<len;i++)
{
num[i]=i+1;	
}

return num;
}
static void shuffleArray(int ar[])
{
	int a,index;
  Random rnd = new Random();
  for (int i = ar.length-1 ; i >0; i--)
  {
    index = rnd.nextInt(i);
    // Simple swap
    a = ar[index];
    ar[index] = ar[i];
    ar[i] = a;
    
  }
  
	}

public void shuffle()
{
	
	shuffleArray(insert());
}

}
