package DDDTutorial_Modd.Voxl;

import CC.COd.Neds_Ovrid;
import static CC.COd.Neds_Ovrid.*;

import CC.Encycloped.Abs.Scal.Physc.Physc_SpAc;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import DDDTutorial_Modd.D3.Polyhedron;
import CC.Encycloped.Abs.Scal.Gom.LOcg_Havr;
import CC.Encycloped.Abs.Scal.Gom.ShAp.D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import java.util.ArrayList;
import java.util.List;
import static CC.Math.Calculatr.Invrt1;
import static DDDTutorial_Modd.Voxl.Blok_Typ.Shud_Cul_SId;
import static DDDTutorial_Modd.Voxl.Voxl_Grid.UpdAt_SId;
import static DDDTutorial_Modd.Voxl.VrtX_Grid.Mid_VrtX_LNg;
import static java.lang.Math.floorDiv;

public class Triangl_Grid extends Grid_3D implements VrtX_Grid
{
	public static final int
		X_Axis=0,
		XYA_Axis=1,
		XYB_Axis=2,
		Z_Axis=3;

	public int XYA_LNg;
	public int XYB_LNg;

	@Override
	public void Get_Atom_LOc(D3_Drawbl_Atom Atom,double[] Box,int[] Loc)
	{
		Atom.Get_Bordr_Out_Box_StRt(Box);
		Get_Loc_SpAc$Grid(Box,Loc);
	}
	@Override
	public int Get_Atom_LOc_Al_Axis(D3_Drawbl_Atom Atom,double[] Box,int[] Loc)
	{
		Get_Atom_LOc(Atom,Box,Loc);

		return
			(Box[0]==Box[1])?X_Axis:
			(Box[2]==Box[3])?XYA_Axis:
			Z_Axis;
	}
	@Override
	public int[] Get_TRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc)
	{
		double[] Box=new double[6];
		Get_Atom_LOc(Atom,Box,Loc);
		int
			X=Loc[0],
			Y=Loc[1],
			Z=Loc[2];

		if(Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		//<editor-fold desc="Prepare for checking voxel on other side">
		else if(Box[0]==Box[1])
		{
//			out.println("Side on X axis");

			X-=1;
			Loc[0]=X;
		}
		else if(Box[2]==Box[3])
		{
//			out.println("Side on Y axis");

			Y-=1;
			Loc[1]=Y;
		}
		else if(Box[4]==Box[5])
		{
//			out.println("Side on Z axis");

			Z-=1;
			Loc[2]=Z;
		}
		//</editor-fold>
		if(Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		else
		{return null;}
	}
	@Override
	public int[] Get_UntRgetbl_Voxl(D3_Drawbl_Atom Atom,int[] Loc)
	{
		double[] Box=new double[6];
		Get_Atom_LOc(Atom,Box,Loc);
		int
			X=Loc[0],
			Y=Loc[1],
			Z=Loc[2];

		if(!Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		//<editor-fold desc="Prepare for checking voxel on other side">
		else if(Box[0]==Box[1])
		{
//			out.println("Side on X axis");

			X-=1;
			Loc[0]=X;
		}
		else if(Box[2]==Box[3])
		{
//			out.println("Side on Y axis");

			Y-=1;
			Loc[1]=Y;
		}
		else if(Box[4]==Box[5])
		{
//			out.println("Side on Z axis");

			Z-=1;
			Loc[2]=Z;
		}
		//</editor-fold>
		if(!Is_TRgetbl_Voxl(X,Y,Z))
		{return Loc;}
		else
		{return null;}
	}
	@Override
	public void PlAc_On_Voxl(D3_Drawbl_Atom Atom,byte ID)
	{
		int[] Loc=Get_UntRgetbl_Voxl(Atom);
		if(Is_In(Loc))
		{Set_Voxl(Loc,ID);}
	}

	public RL_LOc_Havr[][][] VrtXg;
		@Override @Neds_Ovrid(NEds=No)
		public RL_LOc_Havr[][][] Get_VrtXg()
		{return VrtXg;}
		@Override
		public int CalculAt_Y_VrtX_LNg(int LNg)
		{return Mid_VrtX_LNg(LNg);}
		@Override
		public RL_LOc_Havr[][][] MAk_VrtXg(int X_LNg,int Y_LNg,int Z_LNg)
		{
			RL_LOc_Havr[][][] VrtXg=MAk_VrtX_ArA(X_LNg,Y_LNg,Z_LNg);
			RL_LOc_Havr[][] VrtX2;
			RL_LOc_Havr[] VrtX1;
			for(int Z=0;
				Z<Z_LNg;
				Z+=1)
			{
				VrtX2=VrtXg[Z];
				for(int Y=0;
					Y<Y_LNg;
					Y+=1)
				{
					VrtX1=VrtX2[Y];
					for(
						int X=0;
						X<X_LNg;
						X+=1)
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
		Polygong_XYA,
		Polygong_XYB,
		Polygong_Z;
		public Polyhedron Polyhedron;
			@Override
			public Polyhedron Get_Polyhedron()
			{return Polyhedron;}
			@Override
			public void Set_Polyhedron(Polyhedron Polyhedron)
			{this.Polyhedron=Polyhedron;}
		@Override
		public int Polygon_Num()
		{return -1;}
		@Override
		public void Ad_Polygong()
		{
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][]
				Polygong_X2,
				Polygong_XYA2,
				Polygong_XYB2,
				Polygong_Z2;
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[]
				Polygong_X1,
				Polygong_XYA1,
				Polygong_XYB1,
				Polygong_Z1;
			Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Polygon;
			List<D3_Drawbl_Atom> Atomg=new ArrayList<>();
			int
				X=0,X1,
				Y,Y1,Y2,
				Z,Z1;
			for(Z=0;Z<Z_LNg;Z=Z1)
			{
				Z1=Z+1;
				int X_P=1;
				Polygong_X2=Polygong_X[Z];
				Polygong_XYA2=Polygong_XYA[Z];
				Polygong_XYB2=Polygong_XYB[Z];
				Polygong_Z2=Polygong_Z[Z];
				for(Y=0,
					Y1=Y+1;
					Y<XYB_LNg;
					Y=Y1,
					Y1=Y2,
					X_P*=-1,
					X=Invrt1(X))
				{
					Y2=Y1+1;
					Polygong_X1=Polygong_X2[Y];
					Polygong_XYA1=Polygong_XYA2[Y];
					Polygong_XYB1=Polygong_XYB2[Y];
					Polygong_Z1=Polygong_Z2[Y];
					for(;X<X_LNg;X+=1)
					{
						X1=X+X_P;
						Polygon=new Drawbl_D3_Polygon<>(new D3_Polygon<>(
							VrtXg[Z1][Y][X],
							VrtXg[Z1][Y2][X],
							VrtXg[Z][Y2][X],
							VrtXg[Z][Y][X]),
						null,false);
						Polygong_X1[X]=Polygon;
						Atomg.add(Polygon);
						Polygon=new Drawbl_D3_Polygon<>(new D3_Polygon<>(
							VrtXg[Z1][Y][X],
							VrtXg[Z1][Y1][X1],
							VrtXg[Z][Y1][X1],
							VrtXg[Z][Y][X]),
						null,false);
						Polygong_XYA1[X]=Polygon;
						Atomg.add(Polygon);
						Polygon=new Drawbl_D3_Polygon<>(new D3_Polygon<>(
							VrtXg[Z1][Y2][X],
							VrtXg[Z1][Y1][X1],
							VrtXg[Z][Y1][X1],
							VrtXg[Z][Y2][X]),
						null,false);
						Polygong_XYB1[X]=Polygon;
						Atomg.add(Polygon);
						Polygon=new Drawbl_D3_Polygon<>(new D3_Polygon<>(
							VrtXg[Z][Y1][X],
							VrtXg[Z][Y1][X1],
							VrtXg[Z][Y][X1]),
						null,false);
						Polygong_Z1[X]=Polygon;
						Atomg.add(Polygon);
					}
				}
			}
		}
	@Override
	public void Set_Gridg_From_IDg(byte[][][] IDg)
	{
		super.Set_Gridg_From_IDg(IDg);
		VrtXg=MAk_VrtXg(
			X_LNg,
			Y_LNg,
			Z_LNg);
		Polygong_Z=new Drawbl_D3_Polygon[Z_LNg+1][Y_LNg][X_LNg];
		Polygong_X=new Drawbl_D3_Polygon[Z_LNg][Y_LNg][X_LNg+1];
		final int q=Y_LNg/2;
		XYB_LNg=(q*2!=Y_LNg)?
			q+1:
			q;
		XYA_LNg=floorDiv(q,2)+1;
		Polygong_XYA=new Drawbl_D3_Polygon[Z_LNg][XYA_LNg][X_LNg];
		Polygong_XYB=new Drawbl_D3_Polygon[Z_LNg][XYB_LNg][X_LNg];
	}

	@Override
	public void Set_Voxl_Colr(int X,int Y,int Z,Blok_Typ Typ)
	{}

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
					(byte)0b10
				);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.XB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b01
				);
			}
			default->{}
		}
	}
	public void UpdAt_XYA_SId(Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Atom,
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
					(byte)0b01
				);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.YB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b10
				);
			}
			default->{}
		}
	}
	public void UpdAt_XYB_SId(Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Atom,
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
					(byte)0b01
				);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.YB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b10
				);
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
					(byte)0b01
				);
			}
			case 0b0000_1000->
			{
				Atom.Set_Atom(Get_Polyhedron(),
					Top_Typ.ZB(),
					Top_Typ.Is_TRgetbl(),
					(byte)0b10
				);
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
	public void UpdAt_XYA_Axis(
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
		Blok_Typ Mid_Typ,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
	{
		UpdAt_XYA_SId(Bot,Bot_Typ,Mid_Typ);
		UpdAt_XYA_SId(Top,Mid_Typ,Top_Typ);
	}
	public void UpdAt_XYB_Axis(
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Bot,Blok_Typ Bot_Typ,
		Blok_Typ Mid_Typ,
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>> Top,Blok_Typ Top_Typ)
	{
		UpdAt_XYB_SId(Bot,Bot_Typ,Mid_Typ);
		UpdAt_XYB_SId(Top,Mid_Typ,Top_Typ);
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
		Drawbl_D3_Polygon<D3_Polygon<Physc_SpAc,LOcg_Havr<Physc_SpAc>>>[][]
			XYA2=Polygong_XYA[Z],
			XYB2=Polygong_XYB[Z];
		UpdAt_XYA_Axis(
			XYA2[Y][X],Get_Voxl_Typ(X,Y-1,Z),
			Typ,
			XYA2[Y+1][X],Get_Voxl_Typ(X,Y+1,Z));
		UpdAt_XYB_Axis(
			XYB2[Y][X],Get_Voxl_Typ(X,Y-1,Z),
			Typ,
			XYB2[Y+1][X],Get_Voxl_Typ(X,Y+1,Z));
		UpdAt_Z_Axis(
			Polygong_Z[Z][Y][X],Get_Voxl_Typ(X,Y,Z-1),
			Typ,
			Polygong_Z[Z+1][Y][X],Get_Voxl_Typ(X,Y,Z+1));
	}

	@Override
	public void Get_Bordr_Out_Box_StRt(double[] Box)
	{}
	@Override
	public void Get_Bordr_Out_Box(double[] Box)
	{}

	public Triangl_Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,double Voxl_SIz,byte[][][] IDg)
	{
		super(Parnt,LOc_SOrc,Voxl_SIz,IDg);
		UpdAt_Polygong();
	}
}