import Livings.Animals.Animal;
import Livings.Animals.Chicken.TableChicken;
import Specification.DetailedSpecification.HungrySpecification;
import Specification.DetailedSpecification.MatureSpecification;
import Specification.Specification;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpecificationOtherTest {
	List<Animal> animals = new ArrayList<>();
	@Before
	public void setUp(){
		System.out.println("======== 测试 Specification 模式 ========");
		//创建四只tableChicken
		animals.add(new TableChicken(true, true));
		animals.add(new TableChicken(true, false));
		animals.add(new TableChicken(false, true));
		animals.add(new TableChicken(false, false));
	}

	@Test
	public void testForSpecification() {
		//创建规约类
		HungrySpecification isHungry = new HungrySpecification();
		MatureSpecification isMature = new MatureSpecification();
		//组合成四个规约法则
		Specification hungry_mature = isHungry.and(isMature);
		Specification hungry_not_mature = isHungry.and(isMature.not());
		Specification not_hungry_mature = isHungry.not().and(isMature);
		Specification not_hungry_not_mature = isHungry.not().and(isMature.not());

		//用规约法则hungry_mature进行筛选
		for (int i = 0; i < animals.size(); i++) {
			if (hungry_mature.isSatisfiedBy(animals.get(i))) {
				System.out.println("hungry_mature");
				System.out.println(i + "号：" + "@ " + animals.get(i).hashCode());
			}
		}
		//用规约法则hungry_not_mature进行筛选
		for (int i = 0; i < animals.size(); i++) {
			if (hungry_not_mature.isSatisfiedBy(animals.get(i))) {
				System.out.println("hungry_not_mature");
				System.out.println(i + "号：" + "@ " + animals.get(i).hashCode());
			}
		}
		//用规约法则not_hungry_mature进行筛选
		for (int i = 0; i < animals.size(); i++) {
			if (not_hungry_mature.isSatisfiedBy(animals.get(i))) {
				System.out.println("not_hungry_mature");
				System.out.println(i + "号：" + "@ " + animals.get(i).hashCode());
			}
		}
		//用规约法则not_hungry_not_mature进行筛选
		for (int i = 0; i < animals.size(); i++) {
			if (not_hungry_not_mature.isSatisfiedBy(animals.get(i))) {
				System.out.println("not_hungry_not_mature");
				System.out.println(i + "号：" + "@ " + animals.get(i).hashCode());
			}
		}
	}
}
