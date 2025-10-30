package DDDTutorial_Modd.Voxl;

import CC.COd.Finishd;
import CC.COd.Lin_DclAr;

import DDDTutorial_Modd.D2.Bound_Colr_Filr;
import DDDTutorial_Modd.D3.D3_Drawbl_Atom;
import CC.Encycloped.Abs.Scal.Physc.SIt.Drawbl_Atom;
import DDDTutorial_Modd.D3.Drawbl_D3_Polygon;
import CC.Encycloped.Abs.Scal.Gom.RL_LOc_Havr;
import java.awt.*;
import static CC.Encycloped.Abs.Org.Comput.Bi.Int_Byt_Modr.*;
import static CC.List.ArA_X.Get_Last;
import static CC.Math.Cyclr.Cycl;
import static CC.Encycloped.Abs.Scal.Physc.Colr.Colr.*;
import static java.awt.Color.red;
import static java.awt.Color.white;
import static java.lang.Math.max;

public class Ripl_Grid extends SqAr_Grid
{
	public int[][]
		IDg_New;
	public int[][]
		Colrg,
		Colrg_New;
	public int Get_Colr(int X,int Y)
	{
		return Set_Byt0(
			Colrg[Y][X],
			(int)(IDg[Y][X]*127.5));
	}

	@Override @Finishd(Is_Finishd=false)
	public void Set_Gridg_From_IDg(int[][] IDg)
	{
		super.Set_Gridg_From_IDg(IDg);
		IDg_New=new int[Y_LNg][X_LNg];
		Colrg_New=new int[Y_LNg][X_LNg];
	}

	public static Voxl_Typ[] Voxl_Typg=new Voxl_Typ[128];
		@Lin_DclAr @Finishd(Is_Finishd=false)
		public Voxl_Typ[] Get_Typg()
		{return Voxl_Typg;}
		static
		{
			Voxl_Typg[0]=new Voxl_Typ(true,ClEr,true);
			Voxl_Typg[1]=new Voxl_Typ(true,Set_A(white,64),true);
			Voxl_Typg[2]=new Voxl_Typ(true,Set_A(red,64),true);
		}

	public void UpdAt_Voxl(int X,int Y,Voxl_Typ Typ)
	{
		Drawbl_D3_Polygon SqAr=Polygong[Y][X];
		SqAr.Set_Atom(
			Typ.Is_Visbl,
			new Bound_Colr_Filr(Get_Colr(X,Y)),
			Typ.Is_TRgetbl);
	}
	public interface ID_Colr_UpdAtr
	{
		@Lin_DclAr @Finishd(Is_Finishd=false)
		void UpdAt(int[] IDg,int[] Colrg,int X,
			int ID_XB,int Colr_XB,int ID_X,int Colr_X,int ID_XT,int Colr_XT,
			int ID_YB,int Colr_YB,int ID_Y,int Colr_Y,int ID_YT,int Colr_YT,
			int ID_ZB,int Colr_ZB,int ID_Z,int Colr_Z,int ID_ZT,int Colr_ZT);
	}
		public static ID_Colr_UpdAtr[] TSt={
			(IDg,Colrg,X,
				ID_AB,Colr_AB,ID_A,Colr_A,ID_AT,Colr_AT,
				ID_BB,Colr_BB,ID_B,Colr_B,ID_BT,Colr_BT,
				ID_CB,Colr_CB,ID_C,Colr_C,ID_CT,Colr_CT)->
			{
				if(ID_B==2)
				{
					IDg[X]=1;
					Colrg[X]=Colr_A;
				}
				else
				{
					int
						WAv_Fro_Num=0,
						Colr,
						R=0,G=0,B=0;
					if(ID_AB==2)
					{
						Colr=Colr_AB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_A==2)
					{
						Colr=Colr_A;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_AT==2)
					{
						Colr=Colr_AT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_BB==2)
					{
						Colr=Colr_BB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_BT==2)
					{
						Colr=Colr_BT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_CB==2)
					{
						Colr=Colr_CB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_C==2)
					{
						Colr=Colr_C;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_CT==2)
					{
						Colr=Colr_CT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(WAv_Fro_Num!=0)
					{
						Colrg[X]=AsMbl(
							R/WAv_Fro_Num,
							G/WAv_Fro_Num,
							B/WAv_Fro_Num);
						if(ID_B==0)
						{IDg[X]=2;}
					}
					else
					{
						Colrg[X]=Colr_A;
						IDg[X]=max(ID_B-1,0);
					}
				}
			},
			(IDg,Colrg,X,
				ID_AB,Colr_AB,ID_A,Colr_A,ID_AT,Colr_AT,
				ID_BB,Colr_BB,ID_B,Colr_B,ID_BT,Colr_BT,
				ID_CB,Colr_CB,ID_C,Colr_C,ID_CT,Colr_CT)->
			{
				if(ID_B==2)
				{
					IDg[X]=1;
					Colrg[X]=Colr_B;
				}
				else
				{
					int
						WAv_Fro_Num=0,
						Colr,R=0,G=0,B=0;

					if(ID_AB==2)
					{
						Colr=Colr_AB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_A==2)
					{
						Colr=Colr_A;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_AT==2)
					{
						Colr=Colr_AT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_BB==2)
					{
						Colr=Colr_BB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_BT==2)
					{
						Colr=Colr_BT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_CB==2)
					{
						Colr=Colr_CB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_C==2)
					{
						Colr=Colr_C;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_CT==2)
					{
						Colr=Colr_CT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(WAv_Fro_Num!=0)
					{
						Colrg[X]=new Color(
							R/WAv_Fro_Num,
							G/WAv_Fro_Num,
							B/WAv_Fro_Num).getRGB();
						if(ID_B==0)
						{IDg[X]=2;}
					}
					else
					{
						Colrg[X]=Colr_B;
						IDg[X]=max(ID_B-1,0);
					}
				}
			},
			(IDg,Colrg,X,
				ID_AB,Colr_AB,ID_A,Colr_A,ID_AT,Colr_AT,
				ID_BB,Colr_BB,ID_B,Colr_B,ID_BT,Colr_BT,
				ID_CB,Colr_CB,ID_C,Colr_C,ID_CT,Colr_CT)->
			{
				if(ID_B==2)
				{
					IDg[X]=1;
					Colrg[X]=Colr_B;
				}
				else
				{
					int
						WAv_Fro_Num=0,
						Colr,R=0,G=0,B=0;

					if(ID_AB==2)
					{
						Colr=Colr_AB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_A==2)
					{
						Colr=Colr_A;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_AT==2)
					{
						Colr=Colr_AT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_BB==2)
					{
						Colr=Colr_BB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_BT==2)
					{
						Colr=Colr_BT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(ID_CB==2)
					{
						Colr=Colr_CB;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_C==2)
					{
						Colr=Colr_C;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}
					if(ID_CT==2)
					{
						Colr=Colr_CT;
						R+=Get_Byt1_As_Int(Colr);
						G+=Get_Byt2_As_Int(Colr);
						B+=Get_Byt3_As_Int(Colr);
						WAv_Fro_Num+=1;
					}

					if(WAv_Fro_Num!=0)
					{
						Colrg[X]=new Color(
							R/WAv_Fro_Num,
							G/WAv_Fro_Num,
							B/WAv_Fro_Num).getRGB();
						if(ID_B==0)
						{IDg[X]=2;}
					}
					else
					{
						Colrg[X]=Colr_B;
						IDg[X]=max(ID_B-1,0);
					}
				}
			},
		};
	public ID_Colr_UpdAtr UpdAtr=Get_Last(TSt);

	@Override
	public void Tik()
	{
		for(int Y=0;Y<Y_LNg;Y+=1)
		{
			int
				YB=Cycl(Y-1,Y_LNg),
				YT=(Y+1)%Y_LNg;
			int[]
				IDg_A=IDg[YB],
				IDg_B=IDg[Y],
				IDg_C=IDg[YT],
				IDg_B_New=IDg_New[Y];
			int[]
				Colrg_A=Colrg[YB],
				Colrg_B=Colrg[Y],
				Colrg_C=Colrg[YT],
				Colrg_B_New=Colrg_New[Y];
			for(int X=0;X<X_LNg;X+=1)
			{
				int
					XB=Cycl(X-1,X_LNg),
					XT=(X+1)%X_LNg;
				UpdAtr.UpdAt(IDg_B_New,Colrg_B_New,X,
					IDg_A[XB],Colrg_A[XB],IDg_A[X],Colrg_A[X],IDg_A[XT],Colrg_A[XT],
					IDg_B[XB],Colrg_B[XB],IDg_B[X],Colrg_B[X],IDg_B[XT],Colrg_B[XT],
					IDg_C[XB],Colrg_C[XB],IDg_C[X],Colrg_C[X],IDg_C[XT],Colrg_C[XT]);
			}
		}

		int[][] IDg_StOr=IDg;
		IDg=IDg_New;
		IDg_New=IDg_StOr;
		int[][] Colrg_StOr=Colrg;
		Colrg=Colrg_New;
		Colrg_New=Colrg_StOr;

		UpdAt_Voxlg();
	}

	@Override @Finishd(Is_Finishd=false)
	public void Intract(Drawbl_Atom Atom)
	{
		int[] Loc=Get_LOc((D3_Drawbl_Atom)Atom);
		IDg[Loc[1]][Loc[0]]=2;
	}

	@Finishd(Is_Finishd=false)
	public Ripl_Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,
		double Voxl_SIz,int X_LNg,int Y_LNg,int[][] IDg,int[][] Colrg)
	{
		super(Parnt,LOc_SOrc,Voxl_SIz,X_LNg,Y_LNg,IDg);
		this.Colrg=Colrg;
	}
		/**Infers, X, & Y, LNg.*/
		@Finishd(Is_Finishd=false)
		public Ripl_Grid(RL_LOc_Havr Parnt,Object LOc_SOrc,
			double Voxl_SIz,int[][] IDg,int[][] Colrg)
		{this(Parnt,LOc_SOrc,
			Voxl_SIz,IDg[0].length,IDg.length,
			IDg,Colrg);
		}
}