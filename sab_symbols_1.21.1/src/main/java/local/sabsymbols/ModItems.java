package local.sabsymbols;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SabSymbols.MOD_ID);

    public static final DeferredItem<Item> PURITYSEALSOLO = blockItem("puritysealsolo", ModBlocks.PURITYSEALSOLO);
    public static final DeferredItem<Item> PURITYSEALDUO = blockItem("puritysealduo", ModBlocks.PURITYSEALDUO);
    public static final DeferredItem<Item> PURITYSEALTRIO = blockItem("puritysealtrio", ModBlocks.PURITYSEALTRIO);
    public static final DeferredItem<Item> AQUILA = blockItem("aquila", ModBlocks.AQUILA);
    public static final DeferredItem<Item> AQUILASKULL = blockItem("aquilaskull", ModBlocks.AQUILASKULL);
    public static final DeferredItem<Item> BUNDESWEHRCROSS = blockItem("bundeswehrcross", ModBlocks.BUNDESWEHRCROSS);
    public static final DeferredItem<Item> REDSTAR = blockItem("redstar", ModBlocks.REDSTAR);
    public static final DeferredItem<Item> COLONIALSIGN = blockItem("colonialsign", ModBlocks.COLONIALSIGN);
    public static final DeferredItem<Item> WHITESTAR = blockItem("whitestar", ModBlocks.WHITESTAR);
    public static final DeferredItem<Item> FEMBOYSIGN = blockItem("femboysign", ModBlocks.FEMBOYSIGN);

    private static DeferredItem<Item> blockItem(String name, Supplier<? extends Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private ModItems() {}
}
