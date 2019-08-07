package ILoveCats123.RandomlyCute;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ILoveCats123.RandomlyCute.lists.ItemLists;
import net.minecraft.client.resources.ResourceIndex;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("randomlycute")
public class RandomlyCute 
{
	public static RandomlyCute instance;
	public static final String modid = "randomlycute";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public RandomlyCute() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegsitryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getResult().registerAll
			(
					ItemLists.needle = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("needle"))
			);
			logger.info("Items registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}}
}