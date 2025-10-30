package DDDTutorial_Modd.Voxl;

import CC.COd.Lin_DclAr;
import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Gom.LOc;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import DDDTutorial_Modd.Voxl.Voxl_Grid.Voxl_Grid_ConcrEt;
import static CC.List.BAs_ArA.ABC;
import static DDDTutorial_Modd.Voxl.Blok_Typ.Blok_Typg;
import static java.lang.System.out;

public abstract class Grid_3D extends Voxl_Grid_ConcrEt
{
	public int
		X_LNg,
		Y_LNg,
		Z_LNg;
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public boolean Is_In(int X,int Y,int Z)
		{return
			X>=0&&X<X_LNg&&
			Y>=0&&Y<Y_LNg&&
			Z>=0&&Z<Z_LNg;
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public boolean Is_In(int[] Loc)
			{return Is_In(
				Loc[0],
				Loc[1],
				Loc[2]
			);}
	public double Voxl_SIz;
	public byte[][][] IDg;
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public byte[][][] Get_IDg()
		{return IDg;}
		@Lin_DclAr
		public void Set_IDg(byte[][][] IDg)
		{this.IDg=IDg;}
		@Lin_DclAr
		public byte Get_Voxl_ID(int X,int Y,int Z)
		{
			return (Is_In(X,Y,Z))?
				IDg[Z][Y][X]:
				127;
		}
		@Lin_DclAr
		public Blok_Typ Get_Voxl_Typ(int X,int Y,int Z)
		{return Blok_Typg[Get_Voxl_ID(X,Y,Z)];}
			@Lin_DclAr
			public Blok_Typ Get_Voxl_Typ(int[] Loc)
			{return Get_Voxl_Typ(
				Loc[0],
				Loc[1],
				Loc[2]
			);}
		@Lin_DclAr
		public void Set_Voxlg(byte[][][] IDg)
		{this.IDg=IDg;}
		@Override
		public void Set_Voxlg()
		{
			for(int Z=0;Z<Z_LNg;Z+=1)
			{
				for(int Y=0;Y<Y_LNg;Y+=1)
				{
					for(int X=0;X<X_LNg;X+=1)
					{Set_Voxl(X,Y,Z);}
				}
			}
		}
		public Blok_NtiT[][][] Blok_NtiTg;
		@Lin_DclAr
		public void Set_Gridg_From_IDg(byte[][][] IDg)
		{
			Set_IDg(IDg);
			Z_LNg=IDg.length;
			Y_LNg=IDg[0].length;
			X_LNg=IDg[0][0].length;
			out.println("LNg="+X_LNg+","+Y_LNg+","+Z_LNg);
			Blok_NtiTg=new Blok_NtiT[Z_LNg][Y_LNg][X_LNg];
		}
		@Lin_DclAr
		public String IDg_To_String(StringBuilder Bildr)
		{
			byte[] ID1;
			byte[][] ID2;
			for(int Z=0;Z<Z_LNg;Z+=1)
			{
				ID2=IDg[Z];
				for(int Y=0;Y<Y_LNg;Y+=1)
				{
					ID1=ID2[Y];
//					ArA_To_String(Bildr,);
				}
			}

			return Bildr.toString();
		}

	@Lin_DclAr
	public abstract void Set_Voxl_Colr(int X,int Y,int Z,Blok_Typ Typ);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public void Set_Voxl_Colr(int X,int Y,int Z,byte ID)
		{Set_Voxl_Colr(X,Y,Z,Blok_Typg[ID]);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public void Set_Voxl_Colr(int X,int Y,int Z)
			{Set_Voxl_Colr(X,Y,Z,Get_Voxl_ID(X,Y,Z));}
	@Lin_DclAr @Neds_Ovrid(NEds=No)
	public boolean Is_Opaq_Voxl(int X,int Y,int Z)
	{
//		out.println(Blok_Typg[Get_ID(X,Y,Z)].Is_Opaq());

		return Get_Voxl_Typ(X,Y,Z).OpaciT()==2;
	}
	@Lin_DclAr @Neds_Ovrid(NEds=No)
	public boolean Is_TRgetbl_Voxl(int X,int Y,int Z)
	{return Get_Voxl_Typ(X,Y,Z).Is_TRgetbl();}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public boolean Is_TRgetbl_Voxl(int[] Loc)
		{return Is_TRgetbl_Voxl(
			Loc[0],
			Loc[1],
			Loc[2]
		);}

	@Lin_DclAr @Neds_Ovrid(NEds=No)
	public void UpdAt_Voxl(int X,int Y,int Z,
		int Dim,int Dr)
	{Get_Voxl_Typ(X,Y,Z).UpdAt(this,X,Y,Z);}
	@Lin_DclAr
	public void Set_Voxl(int X,int Y,int Z,byte ID,Blok_Typ Typ)
	{
		IDg[Z][Y][X]=ID;
		Typ.UpdAt(this,X,Y,Z);
		this.Set_Voxl_Colr(X,Y,Z,Typ);
		UpdAt_Voxl(X-1,Y,Z,0,1);
		UpdAt_Voxl(X+1,Y,Z,0,-1);
		UpdAt_Voxl(X,Y-1,Z,1,1);
		UpdAt_Voxl(X,Y+1,Z,1,-1);
		UpdAt_Voxl(X,Y,Z-1,2,1);
		UpdAt_Voxl(X,Y,Z+1,2,-1);
	}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public void Set_Voxl(int X,int Y,int Z,byte ID)
		{Set_Voxl(X,Y,Z,ID,Blok_Typg[ID]);}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public void Set_Voxl(int X,int Y,int Z,Blok_Typ Typ)
		{Set_Voxl(X,Y,Z,Typ.Get_ID(),Typ);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public void Set_Voxl(int X,int Y,int Z)
			{Set_Voxl(X,Y,Z,IDg[Z][Y][X]);}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public void Set_Voxl(int[] Loc,byte ID)
		{
			Set_Voxl(
				Loc[0],
				Loc[1],
				Loc[2],
				ID);
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public void Set_Voxl(int[] Loc)
			{Set_Voxl(Loc[0],Loc[1],Loc[2]);}

	@Lin_DclAr
	public abstract void UpdAt_Srfac(int X,int Y,int Z,Blok_Typ Typ);
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public void UpdAt_Srfac(int X,int Y,int Z,byte ID)
		{UpdAt_Srfac(X,Y,Z,Blok_Typg[ID]);}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public void UpdAt_Srfac(int X,int Y,int Z)
			{UpdAt_Srfac(X,Y,Z,Get_Voxl_ID(X,Y,Z));}

	@Lin_DclAr
	public void Get_Loc_SpAc$Grid(double[] SpAc_Loc,int[] Grid_Loc)
	{
		double[] Loc=Get_LOc_CoP_As_ArA();
		ABC(Grid_Loc,
			(int)((SpAc_Loc[0]-Loc[0])/Voxl_SIz),
			(int)((SpAc_Loc[1]-Loc[1])/Voxl_SIz),
			(int)((SpAc_Loc[2]-Loc[2])/Voxl_SIz));
	}
		@Lin_DclAr @Neds_Ovrid(NEds=No)
		public int[] Get_Loc_SpAc$Grid(double[] SpAc_Loc)
		{
			int[] Grid_Loc=new int[3];
			Get_Loc_SpAc$Grid(SpAc_Loc,Grid_Loc);

			return Grid_Loc;
		}
			@Lin_DclAr @Neds_Ovrid(NEds=No)
			public void Get_Loc_SpAc$Grid(LOc SpAc_Loc,int[] Grid_Loc)
			{Get_Loc_SpAc$Grid(SpAc_Loc.$ArA(),Grid_Loc);}
				@Lin_DclAr @Neds_Ovrid(NEds=No)
				public int[] Get_Loc_SpAc$Grid(LOc SpAc_Loc)
				{return Get_Loc_SpAc$Grid(SpAc_Loc.$ArA());}

	public Grid_3D(RL_LOc_Havr Parnt,Object Loc_Sorc,double Voxl_SIz,byte[][][] IDg)
	{
		super(Parnt,Loc_Sorc);
		this.Voxl_SIz=Voxl_SIz;
		Set_Gridg_From_IDg(IDg);
	}
}