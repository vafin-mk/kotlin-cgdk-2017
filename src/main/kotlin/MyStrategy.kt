import model.*

class MyStrategy : Strategy {
  override fun move(me: Player, world: World, game: Game, move: Move) {
    when (world.tickIndex) {
      0 -> {
        with(move) {
          action = ActionType.CLEAR_AND_SELECT
          right = world.width
          bottom = world.height
        }
      }

      1 -> {
        with(move) {
          action = ActionType.MOVE
          x = world.width / 2.0
          y = world.height / 2.0
        }
      }
    }
  }
}
