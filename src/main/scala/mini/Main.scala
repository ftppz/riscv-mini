// See LICENSE for license details.

package mini

import circt.stage.ChiselStage

object Main extends App {
  val config = MiniConfig() // get config parameters(three components) for Tile instantiate 
  ChiselStage.emitSystemVerilogFile( // generate Systeam Verilog file: Tile.sv
    new Tile( // the Top is Tile
      coreParams = config.core, // core parameters
      nastiParams = config.nasti, // bus parameters
      cacheParams = config.cache  // icache and dcache parameters 
    ),
    args  // return command args
  )
}
