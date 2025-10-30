package DDDTutorial_Modd.Voxl;

import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.*;

public class Gom
{
	public static void Mov(int Dim,int Vectr,int[] LOc)
	{LOc[Dim]+=Vectr;}
	public static void Up(int Dim,int[] LOc)
	{Mov(Dim,+1,LOc);}
	public static void Down(int Dim,int[] LOc)
	{Mov(Dim,-1,LOc);}
	public static String B_AdjacnC_To_String(int[] LOc,int Dim)
	{
		StringBuilder Bildr=new StringBuilder();
		ApNd_Rang(Bildr,",",0,Dim,LOc);
		int COrd=LOc[Dim];
		Bildr.append(Rang(COrd,COrd+1));
		ApNd_Rang_(Bildr,",",Dim+1,LOc.length,LOc);

		return Bildr.toString();
	}
	public static String T_AdjacnC_To_String(int[] LOc,int Dim)
	{
		StringBuilder Bildr=new StringBuilder();
		ApNd_Rang(Bildr,",",0,Dim,LOc);
		int Cord=LOc[Dim];
		Bildr.append(Rang(Cord,Cord-1));
		ApNd_Rang_(Bildr,",",Dim+1,LOc.length,LOc);

		return Bildr.toString();
	}
}