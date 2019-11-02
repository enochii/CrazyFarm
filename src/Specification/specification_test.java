package Specification;

import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Specification.DetailedSpecification.HungrySpecification;
import Specification.DetailedSpecification.MatureSpecification;

public class specification_test {
	public static void main(String[] args) {
		System.out.println("有四只动物，分别是饥饿成熟的肉鸡、饥饿不成熟的肉鸡、不饥饿成熟的肉鸡、不饥饿不成熟的肉鸡。");
		String[] animalsTag = {
				"饥饿成熟的肉鸡",
				"饥饿不成熟的肉鸡",
				"不饥饿成熟的肉鸡",
				"不饥饿不成熟的肉鸡",
		};
		Animal[] animals = {
				new TableChicken(true, true),
				new TableChicken(true, false),
				new TableChicken(false, true),
				new TableChicken(false, false),
		};
		System.out.println("创建规约类：HungrySpecification和MatureSpecification。");
		HungrySpecification isHungry = new HungrySpecification();
		MatureSpecification isMature = new MatureSpecification();

		System.out.println("创建四个具体规约法则。");
		Specification hungry_mature = isHungry.and(isMature);
		Specification hungry_not_mature = isHungry.and(isMature.not());
		Specification not_hungry_mature = isHungry.not().and(isMature);
		Specification not_hungry_not_mature = isHungry.not().and(isMature.not());

		System.out.println("开始筛选：");
		System.out.println("1. 使用规约模式hungry_mature筛选饥饿成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(hungry_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]);
			}
		}
		System.out.println("2. 使用规约模式hungry_not_mature筛选饥饿不成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(hungry_not_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]);
			}
		}
		System.out.println("3. 使用规约模式not_hungry_mature筛选不饥饿成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(not_hungry_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]);
			}
		}
		System.out.println("4. 使用规约模式not_hungry_not_mature筛选不饥饿不成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(not_hungry_not_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]);
			}
		}
	}
}
