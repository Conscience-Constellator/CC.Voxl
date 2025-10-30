package DDDTutorial_Modd.Voxl;

import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.*;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon.A_Latrl;
import static CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon.B_Latrl;
import static DDDTutorial_Modd.Voxl.Gom.*;
import static CC.List.List_X.Find;
import static DDDTutorial_Modd.Voxl.Blok_Typ.Shud_Cul_SId;
import static DDDTutorial_Modd.Voxl.Voxl_Grid.UpdAt_SId;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.ParIs;
import static CC.Encycloped.Abs.Org.Syc.TXt.TXt.QOt;

import static java.lang.System.out;

public	class  Cub_VrtX_Grid
		extends     Cub_Grid
		implements VrtX_Grid
{
	public static final int
		X_Axis=0,
		Y_Axis=1,
		Z_Axis=2;

	public static void CalculAt_SId_LOc(int[] LOc,int Axis)
	{LOc[Axis]-=1;}
	public static String Voxl$String(int X,int Y,int Z,Blok_Typ Typ)
	{return X+","+Y+","+Z+"("+Typ+")";}
		public static String Voxl$String(int[] LOc,Blok_Typ Typ)
		{
			return Voxl$String(
				LOc[0],
				LOc[1],
				LOc[2],
			Typ);
		}
	public static String B_SId$String(int[] LOc,int Axis,
		Blok_Typ A,Blok_Typ B)
	{
		return
			QOt((Axis<3)?
				B_AdjacnC_To_String(LOc,Axis):
				"Couldn't find axis"
			)+
			ParIs(A+"-"+B);
	}
	public static String T_SId$String(int[] LOc,int Axis,
		Blok_Typ A,Blok_Typ B)
	{
		return
			QOt((Axis<3)?
				T_AdjacnC_To_String(LOc,Axis):
				"Couldn't find axis"
			)+
			ParIs(A+"-"+B);
	}
//		public static String SId_Pos_To_String(int[] Loc,int Axis)
//		{
//			return ;
//		}
	public D3_Drawbl_Atom[][][] Get_Axis_Polygong(int Axis)
	{
		return switch(Axis)
		{
			case X_Axis->Polygong_X;
			case Y_Axis->Polygong_Y;
			case Z_Axis->Polygong_Z;
			default->{throw new RuntimeException("Invalid axis");}
		};
	}
	@Override
	public void Get_Atom_LOc(D3_Drawbl_Atom Atom,
		double[] Box,int[] LOc)
	{
		Atom.Get_Bordr_Out_Box_StRt(Box);
		Get_Loc_SpAc$Grid(Box,LOc);
	}
	@Override
	public int Get_Atom_LOc_Al_Axis(D3_Drawbl_Atom Atom,
		double[] Box,int[] LOc)
	{
		Get_Atom_LOc(Atom,Box,LOc);
		int Axis=Get_SId_Axis(Box);
		Find(Get_Axis_Polygong(Axis),Atom,LOc);
		return Axis;
	}
	@Override
	public int[] Get_TRgetbl_Voxl(D3_Drawbl_Atom Atom,
		int[] LOc)
	{
		double[] Box=new double[6];

		int Axis=Get_Atom_LOc_Al_Axis(Atom,Box,LOc);

		Blok_Typ
			B_Typ,
			T_Typ=Get_Voxl_Typ(LOc);
			Down(Axis,LOc);
			B_Typ=Get_Voxl_Typ(LOc);
		boolean
			Is_B_TRgetbl=B_Typ.Is_TRgetbl(),
			Is_T_TRgetbl=T_Typ.Is_TRgetbl();
		if(Is_B_TRgetbl)
		{
			if(Is_T_TRgetbl)
			{
				out.println("Ambiguous target on side "+
					B_SId$String(LOc,Axis,B_Typ,T_Typ));
				return null;
			}
			else
			{return LOc;}
		}
		else
		{
			if(Is_T_TRgetbl)
			{
				Up(Axis,LOc);
				return LOc;
			}
			else
			{
				out.println("No target on side "+
					B_SId$String(LOc,Axis,B_Typ,T_Typ));
				return null;
			}
		}
	}
	@Override
	public int[] Get_UntRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] LOc)
	{
		double[] Box=new double[6];
		int Axis=Get_Atom_LOc_Al_Axis(Atom,Box,LOc);

		Blok_Typ
			B_Typ,
			T_Typ=Get_Voxl_Typ(LOc);
		Down(Axis,LOc);
		B_Typ=Get_Voxl_Typ(LOc);
		boolean
			Is_B_TRgetbl=B_Typ.Is_TRgetbl(),
			Is_T_TRgetbl=T_Typ.Is_TRgetbl();
		if(!Is_B_TRgetbl)
		{
			if(!Is_T_TRgetbl)
			{
				out.println("Ambiguous non-target on side "+
					B_SId$String(LOc,Axis,B_Typ,T_Typ));
				return null;
			}
			else
			{return LOc;}
		}
		else
		{
			if(!Is_T_TRgetbl)
			{
				Up(Axis,LOc);
				return LOc;
			}
			else
			{
				out.println("No non-target on side "+
					B_SId$String(LOc,Axis,B_Typ,T_Typ));
				return null;
			}
		}
	}
	@Override
	public void PlAc_On_Voxl(D3_Drawbl_Atom Atom,byte ID)
	{
		int[] Loc=Get_UntRgetbl_Voxl(Atom);
		if(Is_In(Loc))
		{Set_Voxl(Loc,ID);}
	}
	public RL_LOc_Havr[][][] VrtXg;
		@Override
		public RL_LOc_Havr[][][] Get_VrtXg()
		{return VrtXg;}
		@Override
		public RL_LOc_Havr[][][] MAk_VrtXg(int X_LNg,int Y_LNg,int Z_LNg)
		{
			VrtXg=MAk_VrtX_ArA(X_LNg,Y_LNg,Z_LNg);
			RL_LOc_Havr[][] VrtX2;
			RL_LOc_Havr[] VrtX1;
			for(int Z=0;Z<=Z_LNg;Z+=1)
			{
				VrtX2=VrtXg[Z];
				for(int Y=0;Y<=Y_LNg;Y+=1)
				{
					VrtX1=VrtX2[Y];
					for(int X=0;X<=X_LNg;X+=1)
					{
						VrtX1[X]=new RL_LOc_Havr_ConcrEt(this,
							X*Voxl_SIz,
							Y*Voxl_SIz,
							Z*Voxl_SIz);
					}
				}
			}

			return VrtXg;
		}
	public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][][]
		Polygong_X,
		Polygong_Y,
		Polygong_Z;
		//<editor-fold desc="Get_SId">
		@Override
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_XB_Polygon(int X,int Y,int Z)
		{return Polygong_X[Z][Y][X];}
		@Override
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_XT_Polygon(int X,int Y,int Z)
		{return Polygong_X[Z][Y][X+1];}
		@Override
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_YB_Polygon(int X,int Y,int Z)
		{return Polygong_Y[Z][Y][X];}
		@Override
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_YT_Polygon(int X,int Y,int Z)
		{return Polygong_Y[Z][Y+1][X];}
		@Override
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_ZB_Polygon(int X,int Y,int Z)
		{return Polygong_Z[Z][Y][X];}
		@Override
		public Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Get_ZT_Polygon(int X,int Y,int Z)
		{return Polygong_Z[Z+1][Y][X];}
		//</editor-fold>
		public Polyhedron Polyhedron;
			@Override @Neds_Ovrid(NEds=No)
			public void Set_Polyhedron(Polyhedron Polyhedron)
			{this.Polyhedron=Polyhedron;}
			@Override @Neds_Ovrid(NEds=No)
			public Polyhedron Get_Polyhedron()
			{return Polyhedron;}
		@Override @Neds_Ovrid(NEds=No)
		public int Polygon_Num()
		{
			int Vol=
				X_LNg*
				Y_LNg*
				Z_LNg;

			return (Vol*3)+
				(X_LNg*Y_LNg)+
				(X_LNg*Z_LNg)+
				(Y_LNg*Z_LNg);
		}
		@Override
		public void Ad_Polygong()
		{
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][] X2,Y2,Z2;
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[] X1,Y1,Z1;
			int X,Y,Z;
			for(Z=0;Z<Z_LNg;Z+=1)
			{
				X2=Polygong_X[Z];
				for(Y=0;Y<Y_LNg;Y+=1)
				{
					X1=X2[Y];
					for(X=0;X<=X_LNg;X+=1)
					{X1[X]=MAk_X2$2_SId(X,Y,Z);}
				}
			}
			for(Z=0;Z<Z_LNg;Z+=1)
			{
				Y2=Polygong_Y[Z];
				for(Y=0;Y<=Y_LNg;Y+=1)
				{
					Y1=Y2[Y];
					for(X=0;X<X_LNg;X+=1)
					{Y1[X]=MAk_Y2$2_SId(X,Y,Z);}
				}
			}
			for(Z=0;Z<=Z_LNg;Z+=1)
			{
				Z2=Polygong_Z[Z];
				for(Y=0;Y<Y_LNg;Y+=1)
				{
					Z1=Z2[Y];
					for(X=0;X<X_LNg;X+=1)
					{Z1[X]=MAk_Z2$2_SId(X,Y,Z);}
				}
			}
		}
	@Override
	public void Set_Gridg_From_IDg(byte[][][] IDg)
	{
		super.Set_Gridg_From_IDg(IDg);
		int
			X_LNg_=X_LNg+1,
			Y_LNg_=Y_LNg+1,
			Z_LNg_=Z_LNg+1;
		VrtXg=MAk_VrtXg(X_LNg,Y_LNg,Z_LNg);
		Polygong_X=new Drawbl_D3_Polygon[Z_LNg][Y_LNg][X_LNg+1];
		Polygong_Y=new Drawbl_D3_Polygon[Z_LNg][Y_LNg+1][X_LNg];
		Polygong_Z=new Drawbl_D3_Polygon[Z_LNg+1][Y_LNg][X_LNg];
	}

	public void UpdAt_X_SId(Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Atom,
		Blok_Typ Bot_Typ,
		Blok_Typ Top_Typ)
	{
		UpdAt_SId(Atom,Bot_Typ,Top_Typ);
		switch(Shud_Cul_SId(Bot_Typ,Top_Typ))
		{
			case 0,0b0000_1010->
			{Atom.Cul_Atom(Get_Polyhedron());}
			case 0b0000_0010->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Bot_Typ.XT(),
					Bot_Typ.Is_TRgetbl(),
					B_Latrl);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.XB(),
					Top_Typ.Is_TRgetbl(),
					A_Latrl);
			}
			default->{}
		}
	}
	public void UpdAt_Y_SId(Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Atom,
		Blok_Typ Bot_Typ,
		Blok_Typ Top_Typ)
	{
		UpdAt_SId(Atom,Bot_Typ,Top_Typ);
		switch(Shud_Cul_SId(Bot_Typ,Top_Typ))
		{
			case 0,0b0000_1010->
			{Atom.Cul_Atom(Get_Polyhedron());}
			case 0b0000_0010->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Bot_Typ.YT(),
					Bot_Typ.Is_TRgetbl(),
					A_Latrl);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.YB(),
					Top_Typ.Is_TRgetbl(),
					B_Latrl);
			}
			default->{}
		}
	}
	public void UpdAt_Z_SId(Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Atom,
		Blok_Typ Bot_Typ,
		Blok_Typ Top_Typ)
	{
		UpdAt_SId(Atom,Bot_Typ,Top_Typ);
		switch(Shud_Cul_SId(Bot_Typ,Top_Typ))
		{
			case 0,0b0000_1010->
			{Atom.Cul_Atom(Get_Polyhedron());}
			case 0b0000_0010->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Bot_Typ.ZT(),
					Bot_Typ.Is_TRgetbl(),
					B_Latrl);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.ZB(),
					Top_Typ.Is_TRgetbl(),
					A_Latrl);
			}
			default->{}
		}
	}
		public void UpdAt_X_Axis(
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
			Blok_Typ Mid_Typ,
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
		{
			UpdAt_X_SId(Bot,Bot_Typ,Mid_Typ);
			UpdAt_X_SId(Top,Mid_Typ,Top_Typ);
		}
		public void UpdAt_Y_Axis(
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
			Blok_Typ Mid_Typ,
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
		{
			UpdAt_Y_SId(Bot,Bot_Typ,Mid_Typ);
			UpdAt_Y_SId(Top,Mid_Typ,Top_Typ);
		}
		public void UpdAt_Z_Axis(
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
			Blok_Typ Mid_Typ,
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
		{
			UpdAt_Z_SId(Bot,Bot_Typ,Mid_Typ);
			UpdAt_Z_SId(Top,Mid_Typ,Top_Typ);
		}
	@Override
	public void UpdAt_Srfac(int X,int Y,int Z,Blok_Typ Typ)
	{
//		out.println("UpdAt_Srfac");

		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[] X1=Polygong_X[Z][Y];
			UpdAt_X_Axis(
				X1[X],Get_Voxl_Typ(X-1,Y,Z),
				Typ,
				X1[X+1],Get_Voxl_Typ(X+1,Y,Z));
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][] Y2=Polygong_Y[Z];
			UpdAt_Y_Axis(
				Y2[Y][X],Get_Voxl_Typ(X,Y-1,Z),
				Typ,
				Y2[Y+1][X],Get_Voxl_Typ(X,Y+1,Z));
		/*Z*/
			UpdAt_Z_Axis(
				Polygong_Z[Z][Y][X],Get_Voxl_Typ(X,Y,Z-1),
				Typ,
				Polygong_Z[Z+1][Y][X],Get_Voxl_Typ(X,Y,Z+1));
	}

	public Cub_VrtX_Grid(Physc_SpAc SpAc,Object LOc_SOrc,double Voxl_SIz,byte[][][] IDg)
	{
		super(SpAc,LOc_SOrc,Voxl_SIz,IDg);
		UpdAt_Polygong();
	}
}