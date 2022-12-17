package history;

import enums.FILTER_WINNER;
import enums.ORDER_HISTORY;

public class HistoryFilterAndOrder {

	private FILTER_WINNER filterWinner;
	private int[] moveRange;
	private ORDER_HISTORY orderBy;

	public HistoryFilterAndOrder() {
		super();
		filterWinner = FILTER_WINNER.ALL;
		moveRange = null;
		orderBy = ORDER_HISTORY.DATE_DESC;

	}

	public HistoryFilterAndOrder(FILTER_WINNER filterWinner, int[] moveRange) {
		super();
		this.filterWinner = filterWinner;
		this.moveRange = moveRange;
	}

	public FILTER_WINNER getFilterWinner() {
		return filterWinner;
	}

	public int[] getMoveRange() {
		return moveRange;
	}

	public void setFilterWinner(FILTER_WINNER filterWinner) {
		this.filterWinner = filterWinner;
	}

	public void setMoveRange(int[] moveRange) {
		this.moveRange = moveRange;
	}

	public ORDER_HISTORY getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(ORDER_HISTORY orderBy) {
		this.orderBy = orderBy;
	}

}
