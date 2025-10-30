package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.Cub;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.LOc;
import CC.Encycloped.Abs.Scal.Gom.SpAc;
import static DDDTutorial_Modd.Voxl.Blok_Typ.Blok_Typg;
import static DDDTutorial_Modd.D3.Cub.*;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.QOt;

import static java.lang.System.out;

public
	class   Cub_Grid_
	extends Cub_Grid
{
	@Override
	public void Ad_To_SpAc(Physc_SpAc SpAc)
	{}
	@Override
	public void Rmov_From_SpAc(Physc_SpAc SpAc)
	{}

	@Override
	public void Set_Voxlg(byte[][][] IDg)
	{
		super.Set_Voxlg(IDg);
		Pop_Cubg_From_IDg();
	}
	public Cub[][][] Cubg;
		@Override
		public int Polygon_Num()
		{
			Cub[][] Cub2=Cubg[0];

			return Cubg[0].length*
				   Cub2.length*
				   Cubg.length;
		}
		//<editor-fold desc="Get_SId">
		@Override
		public Drawbl_D3_Polygon Get_XB_Polygon(int X,int Y,int Z)
		{return (Drawbl_D3_Polygon)Cubg[Z][Y][X].Drawbl_Atomg[XT_IndX];}
		@Override
		public Drawbl_D3_Polygon Get_XT_Polygon(int X,int Y,int Z)
		{return (Drawbl_D3_Polygon)Cubg[Z][Y][X].Drawbl_Atomg[XB_IndX];}
		@Override
		public Drawbl_D3_Polygon Get_YB_Polygon(int X,int Y,int Z)
		{return (Drawbl_D3_Polygon)Cubg[Z][Y][X].Drawbl_Atomg[YT_IndX];}
		@Override
		public Drawbl_D3_Polygon Get_YT_Polygon(int X,int Y,int Z)
		{return (Drawbl_D3_Polygon)Cubg[Z][Y][X].Drawbl_Atomg[YB_IndX];}
		@Override
		public Drawbl_D3_Polygon Get_ZB_Polygon(int X,int Y,int Z)
		{return (Drawbl_D3_Polygon)Cubg[Z][Y][X].Drawbl_Atomg[ZB_IndX];}
		@Override
		public Drawbl_D3_Polygon Get_ZT_Polygon(int X,int Y,int Z)
		{return (Drawbl_D3_Polygon)Cubg[Z][Y][X].Drawbl_Atomg[ZT_IndX];}
		//</editor-fold>
		public void Pop_Cubg_From_IDg()
		{
			Blok_NtiT[][] Blok_NtiT2;
			Blok_NtiT[] Blok_NtiT1;
			Cub[][] Cub2;
			Cub[] Cub1;
			double[]
				Blok_LOc=new double[3],
				LOc=Get_LOc_CoP_As_ArA();
			for(int Z=0;Z<Z_LNg;Z+=1)
			{
				Blok_NtiT2=Blok_NtiTg[Z];
				Cub2=Cubg[Z];
				for(int Y=0;Y<Y_LNg;Y+=1)
				{
					Blok_NtiT1=Blok_NtiT2[Y];
					Cub1=Cub2[Y];
					for(int X=0;X<X_LNg;X+=1)
					{
						To_SpAc(Blok_LOc,Z,Y,X,LOc);
						Cub Cub=new Voxl(this,new LOc(
							Blok_LOc[0],
							Blok_LOc[1],
							Blok_LOc[2]),
							Voxl_SIz);
						Set_Cub_Colr(Cub,IDg[Z][Y][X]);
						Cul_UnXposd_SIdg(Cub,X,Y,Z);
						Cub1[X]=Cub;

						Blok_NtiT NtiT=null;
						Blok_NtiT1[X]=NtiT;
					}
				}
			}
		}
		public int[] Find_Loc(Voxl Voxl)
		{
			Cub[] Cub1;
			Cub[][] Cub2;
			for(int Z=0;Z<Z_LNg;Z+=1)
			{
				Cub2=Cubg[Z];
				for(int Y=0;Y<Y_LNg;Y+=1)
				{
					Cub1=Cub2[Y];
					for(int X=0;X<X_LNg;X+=1)
					{
						if(Cub1[X]==Voxl)
						{return new int[]{X,Y,Z};}
					}
				}
			}
			return null;
		}
		@Lin_DclAr
		@Neds_Ovrid(NEds=No)
		public void Set_Gridg_From_IDg(byte[][][] IDg)
		{
			super.Set_Gridg_From_IDg(IDg);
			Cubg=new Cub[Z_LNg][Y_LNg][X_LNg];
			Set_Voxlg(IDg);
		}
	@Override
	public void Set_Voxl(int X,int Y,int Z,byte ID)
	{
		super.Set_Voxl(X,Y,Z,ID);
		Set_Voxl_Colr(X,Y,Z,ID);
	}
	public static void Set_Cub_Colr(Cub Cub,Blok_Typ Typ)
	{
		try
		{
			D3_Drawbl_Atom[] Polygong=Cub.Drawbl_Atomg;
			Polygong[XT_IndX].Set_Filr(Typ.ZB());
			Polygong[XB_IndX].Set_Filr(Typ.ZT());
			Polygong[YT_IndX].Set_Filr(Typ.YB());
			Polygong[YB_IndX].Set_Filr(Typ.YT());
			Polygong[ZB_IndX].Set_Filr(Typ.XB());
			Polygong[ZT_IndX].Set_Filr(Typ.XT());
		}
		catch(Exception X)
		{
			out.println("Problem w/ block ID "+QOt(Typ.Get_ID()));
			throw X;
		}
	}
		public static void Set_Cub_Colr(Cub Cub,byte ID)
		{Set_Cub_Colr(Cub,Blok_Typg[ID]);}
			@Override
			public void Set_Voxl_Colr(int X,int Y,int Z,Blok_Typ Typ)
			{Set_Cub_Colr(Cubg[Z][Y][X],Typ);}
	@Override
	public void Get_Atom_LOc(D3_Drawbl_Atom Atom,double[] Box,int[] Loc)
	{}
	@Override
	public int Get_Atom_LOc_Al_Axis(D3_Drawbl_Atom Atom,double[] Box,int[] Loc)
	{return 0;}
	@Override
	public int[] Get_TRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc)
	{
		return new int[0];
	}
	@Override
	public int[] Get_UntRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc)
	{
		return new int[0];
	}
	@Override
	public void PlAc_On_Voxl(D3_Drawbl_Atom Atom,byte ID)
	{}

	@Lin_DclAr
	public void Cul_UnXposd_SIdg(Cub Cub,int X,int Y,int Z)
	{
		Cub.Drawbl_Atomg[XT_IndX].Set_Is_Visbl(Is_XB_Visbl(X,Y,Z));
		Cub.Drawbl_Atomg[XB_IndX].Set_Is_Visbl(Is_XT_Visbl(X,Y,Z));
		Cub.Drawbl_Atomg[YT_IndX].Set_Is_Visbl(Is_YB_Visbl(X,Y,Z));
		Cub.Drawbl_Atomg[YB_IndX].Set_Is_Visbl(Is_YT_Visbl(X,Y,Z));
		Cub.Drawbl_Atomg[ZB_IndX].Set_Is_Visbl(Is_ZB_Visbl(X,Y,Z));
		Cub.Drawbl_Atomg[ZT_IndX].Set_Is_Visbl(Is_ZT_Visbl(X,Y,Z));
	}
		@Override @Neds_Ovrid(NEds=No)
		public void UpdAt_Srfac(int X,int Y,int Z,Blok_Typ Typ)
		{Cul_UnXposd_SIdg(Cubg[Z][Y][X],X,Y,Z);}

	public Cub_Grid_(SpAc SpAc,Object LOc_SOrc,double Voxl_SIz,byte[][][] IDg)
	{super(SpAc,LOc_SOrc,Voxl_SIz,IDg);}
}