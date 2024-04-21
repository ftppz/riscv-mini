// See LICENSE for license details.

package mini

import junctions.NastiBundleParameters

// u can have external accesss to class parameters at run time 
// and no need to use 'new' when instantiating
case class Config(core: CoreConfig, 
                  cache: CacheConfig, 
                  nasti: NastiBundleParameters)

object MiniConfig {
  def apply(): Config = {
    val xlen = 32 // 32 bit core
    Config( // use case class Config
      core = CoreConfig(  // instantiate the three main components within the core
        xlen = xlen,
        makeAlu = new AluArea(_),
        makeBrCond = new BrCondArea(_),
        makeImmGen = new ImmGenWire(_)
      ),
      cache = CacheConfig(
        nWays = 1,
        nSets = 256,
        blockBytes = 4 * (xlen / 8) // 4 * 32 bits = 16B
      ),
      nasti = NastiBundleParameters(
        addrBits = 32,
        dataBits = 64,
        idBits = 5
      )
    )
  }
}
