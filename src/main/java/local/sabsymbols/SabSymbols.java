package local.sabsymbols;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/** Port of the decorative symbol blocks of "Steel armor blocks" 1.4.3 (Forge 1.20.1) to NeoForge 1.21.1. */
@Mod(SabSymbols.MOD_ID)
public class SabSymbols {
    /** Kept identical to the original mod so block/item ids (s_a_b:aquila, ...) stay the same. */
    public static final String MOD_ID = "s_a_b";

    public SabSymbols(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModTabs.TABS.register(modEventBus);
    }
}
