import Decorator.AnimalDecorator.FreshDecorator;
import Decorator.AnimalDecorator.StaleDecorator;
import Decorator.PlantDecorator.OrganicDecorator;
import Decorator.PlantDecorator.TransgenosisDecorator;
import Livings.Animals.Chicken.TableChicken;
import Livings.Plants.Crop;
import org.junit.Before;
import org.junit.Test;

public class DecoratorOtherTest{
	private TableChicken tableChicken;
	private Crop crop;

	@Before
	public void setUp(){
		System.out.println("======== 测试 Decorator 模式 ========");
		//建立需要的具体动物（动物类的子类TableChicken）和具体植物（植物类的子类Crop）
		tableChicken = new TableChicken();
		crop = new Crop();
	}

	@Test
	public void testForAnimalDecorator(){
		FreshDecorator freshTableChicken = new FreshDecorator(tableChicken);
		System.out.println("测试FreshDecorator装饰前后的tableChicken价格变化");
		System.out.println("Before: "+tableChicken.getValue());
		System.out.println("After: "+freshTableChicken.getValue());

		StaleDecorator staleTableChicken = new StaleDecorator(tableChicken);
		System.out.println("测试StaleDecorator装饰前后的tableChicken价格变化");
		System.out.println("Before: "+tableChicken.getValue());
		System.out.println("After: "+staleTableChicken.getValue());
	}

	@Test
	public void testForPlantDecorator(){
		OrganicDecorator organicCrop = new OrganicDecorator(crop);
		System.out.println("测试OrganicDecorator装饰前后的crop价格变化");
		System.out.println("Before: "+crop.getValue());
		System.out.println("After: "+organicCrop.getValue());

		TransgenosisDecorator transgenosisCrop = new TransgenosisDecorator(crop);
		System.out.println("测试TransgenosisDecorator装饰前后的crop价格变化");
		System.out.println("Before: "+crop.getValue());
		System.out.println("After: "+transgenosisCrop.getValue());
	}
}