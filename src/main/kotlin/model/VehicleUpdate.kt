package model

/**
 * Класс, частично определяющий технику. Содержит уникальный идентификатор техники, а также все поля техники,
 * значения которых могут изменяться в процессе игры.
 */
class VehicleUpdate(
    /**
     * @return Возвращает уникальный идентификатор объекта.
     */
    val id: Long,
    /**
     * @return Возвращает X-координату центра объекта. Ось абсцисс направлена слева направо.
     */
    val x: Double,
    /**
     * @return Возвращает Y-координату центра объекта. Ось ординат направлена сверху вниз.
     */
    val y: Double,
    /**
     * @return Возвращает текущую прочность или `0`, если техника была уничтожена либо ушла из зоны видимости.
     */
    val durability: Int,
    /**
     * @return Возвращает количество тиков, оставшееся до следующей атаки.
     * Для совершения атаки необходимо, чтобы это значение было равно нулю.
     */
    val remainingAttackCooldownTicks: Int,
    /**
     * @return Возвращает `true` в том и только том случае, если эта техника выделена.
     */
    val isSelected: Boolean,
    groups: IntArray) {


  private val _groups: IntArray = groups.copyOf()
  /**
   * @return Возвращает группы, в которые входит эта техника.
   */
  val groups: IntArray
    get() = _groups.copyOf()
}
