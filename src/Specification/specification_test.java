package Specification;

import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Specification.DetailedSpecification.HungrySpecification;
import Specification.DetailedSpecification.MatureSpecification;

public class specification_test {
	public specification_test(){
		String[] animalsTag = {
				"饥饿成熟的肉鸡",
				"饥饿不成熟的肉鸡",
				"不饥饿成熟的肉鸡",
				"不饥饿不成熟的肉鸡",
				"饥饿成熟的肉鸡",
				"饥饿不成熟的肉鸡",
		};
		Animal[] animals = {
				new TableChicken(true, true),
				new TableChicken(true, false),
				new TableChicken(false, true),
				new TableChicken(false, false),
				new TableChicken(true, true),
				new TableChicken(true, false),
		};

		for(int i=0;i<animals.length;i++){
			System.out.println("生成动物"+animalsTag[i]+"@"+animals[i].hashCode());
		}

		HungrySpecification isHungry = new HungrySpecification();
		MatureSpecification isMature = new MatureSpecification();
		System.out.println("新建规约类 HungrySpecification@"+isHungry.hashCode()+" 和 MatureSpecification@"+isMature.hashCode());

		System.out.println("组合得到四个具体规约法则。");
		Specification hungry_mature = isHungry.and(isMature);
		System.out.println("hungry_mature@"+hungry_mature.hashCode());
		Specification hungry_not_mature = isHungry.and(isMature.not());
		System.out.println("hungry_not_mature@"+hungry_not_mature.hashCode());
		Specification not_hungry_mature = isHungry.not().and(isMature);
		System.out.println("not_hungry_mature@"+not_hungry_mature.hashCode());
		Specification not_hungry_not_mature = isHungry.not().and(isMature.not());
		System.out.println("not_hungry_not_mature@"+not_hungry_not_mature.hashCode());

		System.out.println("开始筛选：");
		System.out.println("1. 使用规约模式hungry_mature筛选饥饿成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(hungry_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]+" @"+animals[i].hashCode());
			}
		}
		System.out.println("2. 使用规约模式hungry_not_mature筛选饥饿不成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(hungry_not_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]+" @"+animals[i].hashCode());
			}
		}
		System.out.println("3. 使用规约模式not_hungry_mature筛选不饥饿成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(not_hungry_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]+" @"+animals[i].hashCode());
			}
		}
		System.out.println("4. 使用规约模式not_hungry_not_mature筛选不饥饿不成熟的动物。");
		for(int i=0;i<animals.length;i++){
			if(not_hungry_not_mature.isSatisfiedBy(animals[i])){
				System.out.println("筛选出:"+animalsTag[i]+" @"+animals[i].hashCode());
			}
		}
	}
}
