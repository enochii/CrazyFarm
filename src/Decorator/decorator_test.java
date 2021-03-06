package Decorator;

import Decorator.AnimalDecorator.FreshDecorator;
import Decorator.AnimalDecorator.StaleDecorator;
import Decorator.PlantDecorator.OrganicDecorator;
import Decorator.PlantDecorator.TransgenosisDecorator;
import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Livings.Animals.Duck.SmallYellowDuck;
import Livings.Plants.Crop;

public class decorator_test {
	public static void main(String[] args) {

		//animal decorator test
		TableChicken tc = new TableChicken();
		System.out.println("普通的tableChicken值"+tc.getValue()+"元。");
		FreshDecorator d_tc = new FreshDecorator(tc);
		System.out.println("新鲜的tableChicken值"+d_tc.getValue()+"元。");
		StaleDecorator d_sc = new StaleDecorator(tc);
		System.out.println("陈腐的tableChicken值"+d_sc.getValue()+"元。");


		//plant decorator test
		Crop c = new Crop();
		System.out.println("普通的crop值"+c.getValue()+"元。");
		OrganicDecorator d_oc = new OrganicDecorator(c);
		System.out.println("有机的crop值"+d_oc.getValue()+"元。");
		TransgenosisDecorator d_tgc = new TransgenosisDecorator(c);
		System.out.println("转基因的crop值"+d_tgc.getValue()+"元。");

	}
}
