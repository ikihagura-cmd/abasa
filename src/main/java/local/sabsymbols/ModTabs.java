package local.sabsymbols;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SabSymbols.MOD_ID);

    /** Same tab name/icon as the original "Armor decoration" tab, holding only the symbol blocks. */
    public static final java.util.function.Supplier<CreativeModeTab> ARMORDECORATION = TABS.register("armordecoration",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.s_a_b.armordecoration"))
                    .icon(() -> new ItemStack(ModBlocks.PURITYSEALTRIO.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.PURITYSEALSOLO.get().asItem());
                        output.accept(ModBlocks.AQUILA.get().asItem());
                        output.accept(ModBlocks.AQUILASKULL.get().asItem());
                        output.accept(ModBlocks.BUNDESWEHRCROSS.get().asItem());
                        output.accept(ModBlocks.REDSTAR.get().asItem());
                        output.accept(ModBlocks.COLONIALSIGN.get().asItem());
                        output.accept(ModBlocks.WHITESTAR.get().asItem());
                        output.accept(ModBlocks.FEMBOYSIGN.get().asItem());
                    })
                    .build());

    private ModTabs() {}
}
