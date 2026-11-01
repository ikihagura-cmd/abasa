package local.sabsymbols;

import local.sabsymbols.block.AquilaBlock;
import local.sabsymbols.block.FlatSymbolBlock;
import local.sabsymbols.block.PuritySealBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SabSymbols.MOD_ID);

    // Purity seals: solo -> duo -> trio (right-click with a solo seal in the main hand).
    public static final DeferredBlock<Block> PURITYSEALSOLO =
            BLOCKS.register("puritysealsolo", () -> new PuritySealBlock(() -> ModBlocks.PURITYSEALDUO.get()));
    public static final DeferredBlock<Block> PURITYSEALDUO =
            BLOCKS.register("puritysealduo", () -> new PuritySealBlock(() -> ModBlocks.PURITYSEALTRIO.get()));
    public static final DeferredBlock<Block> PURITYSEALTRIO =
            BLOCKS.register("puritysealtrio", () -> new PuritySealBlock(null));

    public static final DeferredBlock<Block> AQUILA = BLOCKS.register("aquila", AquilaBlock::new);
    public static final DeferredBlock<Block> AQUILASKULL = BLOCKS.register("aquilaskull", AquilaBlock::new);

    public static final DeferredBlock<Block> BUNDESWEHRCROSS = BLOCKS.register("bundeswehrcross", FlatSymbolBlock::new);
    public static final DeferredBlock<Block> REDSTAR = BLOCKS.register("redstar", FlatSymbolBlock::new);
    public static final DeferredBlock<Block> COLONIALSIGN = BLOCKS.register("colonialsign", FlatSymbolBlock::new);
    public static final DeferredBlock<Block> WHITESTAR = BLOCKS.register("whitestar", FlatSymbolBlock::new);
    public static final DeferredBlock<Block> FEMBOYSIGN = BLOCKS.register("femboysign", FlatSymbolBlock::new);

    private ModBlocks() {}
}
