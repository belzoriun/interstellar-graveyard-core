package fr.raised_controller.interstellar_graveyard.board.chunk;

import fr.raised_controller.interstellar_graveyard.registry.Registry;

public abstract class ChunkBuilders {
	public static final ChunkBuilderProvider OPENSIMPLEX_NOISE_CHUNK_BUILDER = register("opensimplexnoise_chunk_builder", (seed)->new OpenSimplexChunkBuilder(seed));
	
	private static ChunkBuilderProvider register(String id, ChunkBuilderProvider provider)
	{
		return Registry.register(Registry.CHUNK_BUILDER, id, provider);
	}
}
