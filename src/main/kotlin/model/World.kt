package model

/**
 * Этот класс описывает игровой мир. Содержит также описания всех игроков, игровых объектов (<<юнитов>>) и сооружений.
</юнитов> */
class World(
    /**
     * @return Возвращает номер текущего тика.
     */
    val tickIndex: Int,
    /**
     * @return Возвращает базовую длительность игры в тиках. Реальная длительность может отличаться от этого значения в
     * меньшую сторону. Эквивалентно `game.tickCount`.
     */
    val tickCount: Int,
    /**
     * @return Возвращает ширину мира.
     */
    val width: Double,
    /**
     * @return Возвращает высоту мира.
     */
    val height: Double,
    players: Array<Player>, newVehicles: Array<Vehicle>,
    vehicleUpdates: Array<VehicleUpdate>, terrainByCellXY: Array<Array<TerrainType>>,
    weatherByCellXY: Array<Array<WeatherType>>,
    facilities: Array<Facility>) {

  private val _players = players.copyOf()
  /**
   * @return Возвращает список игроков (в случайном порядке).
   * В зависимости от реализации, объекты, задающие игроков, могут пересоздаваться после каждого тика.
   */
  val players: Array<Player>
    get() = _players.copyOf()


  private val _newVehicles = newVehicles.copyOf()
  /**
   * @return Возвращает список техники, о которой у стратегии не было информации в предыдущий игровой тик. В этот
   * список попадает как только что произведённая техника, так и уже существующая, но находящаяся вне зоны видимости
   * до этого момента.
   */
  val newVehicles: Array<Vehicle>
    get() = _newVehicles.copyOf()

  private val _vehicleUpdates = vehicleUpdates.copyOf()
  /**
   * @return Возвращает значения изменяемых полей для каждой видимой техники, если хотя бы одно поле этой техники
   * изменилось. Нулевая прочность означает, что техника была уничтожена либо ушла из зоны видимости.
   */
  val vehicleUpdates: Array<VehicleUpdate>
    get() = _vehicleUpdates.copyOf()


  private val _terrainByCellXY = Array(terrainByCellXY.size, { index -> terrainByCellXY[index].copyOf() })
  /**
   * @return Возвращает карту местности.
   */
  val terrainByCellXY: Array<Array<TerrainType>>
    get() = Array(_terrainByCellXY.size, { index -> _terrainByCellXY[index].copyOf() })

  private val _weatherByCellXY = Array(weatherByCellXY.size, { index -> weatherByCellXY[index].copyOf() })
  /**
   * @return Возвращает карту погоды.
   */
  val weatherByCellXY: Array<Array<WeatherType>>
    get() = Array(_weatherByCellXY.size, { index -> _weatherByCellXY[index].copyOf() })

  private val _facilities = facilities.copyOf()
  /**
   * @return Возвращает список сооружений (в случайном порядке).
   * В зависимости от реализации, объекты, задающие сооружения, могут пересоздаваться после каждого тика.
   */
  val facilities: Array<Facility>
    get() = _facilities.copyOf()

  /**
   * @return Возвращает вашего игрока.
   */
  val myPlayer: Player?
    get() = players.firstOrNull { it.isMe }

  /**
   * @return Возвращает игрока, соревнующегося с вами.
   */
  val opponentPlayer: Player?
    get() = players.firstOrNull { !it.isMe }
}
