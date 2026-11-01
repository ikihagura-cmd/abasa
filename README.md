# Steel armor blocks – Symbols (porte 1.21.1, NeoForge) – uso pessoal

Porte dos 10 blocos-símbolo do mod "Steel armor blocks" 1.4.3 (Forge 1.20.1) para NeoForge 1.21.1.
Não redistribuir (o original é All Rights Reserved).

Blocos (ids iguais ao original, modid `s_a_b`):
`aquila`, `aquilaskull`, `bundeswehrcross`, `redstar`, `whitestar`, `colonialsign`, `femboysign` ("Warden sign"),
`puritysealsolo`, `puritysealduo`, `puritysealtrio`.

## Como compilar
Requer JDK 21. Na pasta do projeto:

    ./gradlew build        (Windows: gradlew.bat build)

O jar sai em `build/libs/sab_symbols-1.0.0.jar` → colocar em `mods/` do NeoForge 1.21.1.
Se o Gradle não achar `neo_version`, troque em `gradle.properties` por qualquer 21.1.x existente.
Para testar sem instalar: `./gradlew runClient`.

## Comportamento (igual ao 1.20.1)
- Aquila / Aquila com caveira: placa de 3 blocos de largura, sem colisão, 6 orientações, dureza 1 / resistência 10, som de cobre.
- Cruz, estrelas e sinais: decalque de 1 pixel, quebra instantânea, sem colisão, 6 orientações, waterlogged, som de metal.
- Selo de pureza: caixa 12x12x1, dureza 0,5, som de vela. Clique direito com o selo solo na mão principal
  troca solo → duo → trio (som de vela, mantém orientação, consome 1 item). Trio não interage.
- Todos dropam a si mesmos. Aba criativa "Armor decoration" (ícone: selo trio).
- Receitas: selo solo = vela + papel (sem forma); estrela vermelha e cruz Bundeswehr = Create `iron_sheet` no
  cortador de pedra (agora só carrega se o Create estiver instalado).

## Inferências (não deu para executar o mod original)
Propriedades foram lidas do bytecode (nomes SRG). Duas são inferência: som do selo = CANDLE e
`ignitedByLava` no selo (só afeta lava).
