package model

/**
 * Класс, определяющий технику. Содержит также все свойства круглых объектов.
 */
class Vehicle : CircularUnit {
  /**
   * @return Возвращает идентификатор игрока, которому принадлежит техника.
   */
  val playerId: Long
  /**
   * @return Возвращает текущую прочность.
   */
  val durability: Int
  /**
   * @return Возвращает максимальную прочность.
   */
  val maxDurability: Int
  /**
   * @return Возвращает максимальное расстояние, на которое данная техника может переместиться за один игровой тик,
   * без учёта типа местности и погоды. При перемещении по дуге учитывается длина дуги,
   * а не кратчайшее расстояние между начальной и конечной точками.
   */
  val maxSpeed: Double
  /**
   * @return Возвращает максимальное расстояние (от центра до центра),
   * на котором данная техника обнаруживает другие объекты, без учёта типа местности и погоды.
   */
  val visionRange: Double
  /**
   * @return Возвращает квадрат максимального расстояния (от центра до центра),
   * на котором данная техника обнаруживает другие объекты, без учёта типа местности и погоды.
   */
  val squaredVisionRange: Double
  /**
   * @return Возвращает максимальное расстояние (от центра до центра),
   * на котором данная техника может атаковать наземные объекты.
   */
  val groundAttackRange: Double
  /**
   * @return Возвращает квадрат максимального расстояния (от центра до центра),
   * на котором данная техника может атаковать наземные объекты.
   */
  val squaredGroundAttackRange: Double
  /**
   * @return Возвращает максимальное расстояние (от центра до центра),
   * на котором данная техника может атаковать воздушные объекты.
   */
  val aerialAttackRange: Double
  /**
   * @return Возвращает квадрат максимального расстояния (от центра до центра),
   * на котором данная техника может атаковать воздушные объекты.
   */
  val squaredAerialAttackRange: Double
  /**
   * @return Возвращает урон одной атаки по наземному объекту.
   */
  val groundDamage: Int
  /**
   * @return Возвращает урон одной атаки по воздушному объекту.
   */
  val aerialDamage: Int
  /**
   * @return Возвращает защиту от атак наземных юнитов.
   */
  val groundDefence: Int
  /**
   * @return Возвращает защиту от атак воздушых юнитов.
   */
  val aerialDefence: Int
  /**
   * @return Возвращает минимально возможный интервал между двумя последовательными атаками данной техники.
   */
  val attackCooldownTicks: Int
  /**
   * @return Возвращает количество тиков, оставшееся до следующей атаки.
   * Для совершения атаки необходимо, чтобы это значение было равно нулю.
   */
  val remainingAttackCooldownTicks: Int
  /**
   * @return Возвращает тип техники.
   */
  val type: VehicleType
  /**
   * @return Возвращает `true` в том и только том случае, если эта техника воздушная.
   */
  val isAerial: Boolean
  /**
   * @return Возвращает `true` в том и только том случае, если эта техника выделена.
   */
  val isSelected: Boolean
  private val _groups: IntArray
  /**
   * @return Возвращает группы, в которые входит эта техника.
   */
  val groups: IntArray
    get() = _groups.copyOf()

  constructor(
      id: Long, x: Double, y: Double, radius: Double, playerId: Long, durability: Int, maxDurability: Int,
      maxSpeed: Double, visionRange: Double, squaredVisionRange: Double, groundAttackRange: Double,
      squaredGroundAttackRange: Double, aerialAttackRange: Double, squaredAerialAttackRange: Double,
      groundDamage: Int, aerialDamage: Int, groundDefence: Int, aerialDefence: Int, attackCooldownTicks: Int,
      remainingAttackCooldownTicks: Int, type: VehicleType, aerial: Boolean, selected: Boolean, groups: IntArray) : super(id, x, y, radius) {

    this.playerId = playerId
    this.durability = durability
    this.maxDurability = maxDurability
    this.maxSpeed = maxSpeed
    this.visionRange = visionRange
    this.squaredVisionRange = squaredVisionRange
    this.groundAttackRange = groundAttackRange
    this.squaredGroundAttackRange = squaredGroundAttackRange
    this.aerialAttackRange = aerialAttackRange
    this.squaredAerialAttackRange = squaredAerialAttackRange
    this.groundDamage = groundDamage
    this.aerialDamage = aerialDamage
    this.groundDefence = groundDefence
    this.aerialDefence = aerialDefence
    this.attackCooldownTicks = attackCooldownTicks
    this.remainingAttackCooldownTicks = remainingAttackCooldownTicks
    this.type = type
    this.isAerial = aerial
    this.isSelected = selected
    this._groups = groups.copyOf()
  }

  constructor(vehicle: Vehicle, vehicleUpdate: VehicleUpdate) : super(vehicle.id, vehicleUpdate.x, vehicleUpdate.y, vehicle.radius) {

    this.playerId = vehicle.playerId
    this.durability = vehicleUpdate.durability
    this.maxDurability = vehicle.maxDurability
    this.maxSpeed = vehicle.maxSpeed
    this.visionRange = vehicle.visionRange
    this.squaredVisionRange = vehicle.squaredVisionRange
    this.groundAttackRange = vehicle.groundAttackRange
    this.squaredGroundAttackRange = vehicle.squaredGroundAttackRange
    this.aerialAttackRange = vehicle.aerialAttackRange
    this.squaredAerialAttackRange = vehicle.squaredAerialAttackRange
    this.groundDamage = vehicle.groundDamage
    this.aerialDamage = vehicle.aerialDamage
    this.groundDefence = vehicle.groundDefence
    this.aerialDefence = vehicle.aerialDefence
    this.attackCooldownTicks = vehicle.attackCooldownTicks
    this.remainingAttackCooldownTicks = vehicleUpdate.remainingAttackCooldownTicks
    this.type = vehicle.type
    this.isAerial = vehicle.isAerial
    this.isSelected = vehicleUpdate.isSelected

    this._groups = vehicleUpdate.groups.copyOf()
  }
}
