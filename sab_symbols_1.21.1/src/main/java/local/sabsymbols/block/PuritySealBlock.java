package local.sabsymbols.block;

import java.util.function.Supplier;

import local.sabsymbols.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * Wax purity seal (solo / duo / trio). Right-clicking a solo or duo seal with a SOLO seal item in the
 * main hand plays the candle-place sound, upgrades the block (solo -> duo -> trio), keeps its facing and
 * consumes one item. The trio seal has no interaction. {@code upgrade == null} means "no interaction".
 */
public class PuritySealBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    private final Supplier<? extends Block> upgrade;

    public PuritySealBlock(Supplier<? extends Block> upgrade) {
        super(BlockBehaviour.Properties.of()
                .ignitedByLava()
                .sound(SoundType.CANDLE)
                .strength(0.5f)
                .noOcclusion()
                .isViewBlocking((state, level, pos) -> false));
        this.upgrade = upgrade;
        registerDefaultState(stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            case NORTH -> box(2, 2, 15, 14, 14, 16);
            case EAST -> box(0, 2, 2, 1, 14, 14);
            case WEST -> box(15, 2, 2, 16, 14, 14);
            case UP -> box(2, 0, 2, 14, 1, 14);
            case DOWN -> box(2, 15, 2, 14, 16, 14);
            default -> box(2, 2, 0, 14, 14, 1); // SOUTH
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (upgrade == null) {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
        ItemStack held = player.getMainHandItem();
        if (held.getItem() == ModBlocks.PURITYSEALSOLO.get().asItem()) {
            if (!level.isClientSide()) {
                level.playSound(null, pos, SoundEvents.CANDLE_PLACE, SoundSource.BLOCKS, 1f, 1f);
            } else {
                level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.CANDLE_PLACE, SoundSource.BLOCKS, 1f, 1f, false);
            }
            level.setBlock(pos, upgrade.get().defaultBlockState().setValue(FACING, state.getValue(FACING)), 3);
            held.shrink(1);
        }
        return InteractionResult.SUCCESS;
    }
}
