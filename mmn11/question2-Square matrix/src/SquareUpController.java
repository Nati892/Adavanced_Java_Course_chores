/**
 * @author netanel cohen gindi
 */

/*
 *I didn't want to use a matrix for this,
 * so I used a list of points to hold the squares top-left corners.
 * 
 * */

import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SquareUpController
{

	final int SQAURE_SIDE_LENGTH = 10;
	final int TEN_PRECENT = 10;
	final int SQUARE_BOARDER=11;

	private int num_of_rows;
	private int num_of_columns;

	ArrayList<Point> squares = new ArrayList<Point>();/* used to add squares */
	Random rand = new Random();
	private GraphicsContext gc;

	@FXML
    private VBox my_vbox;

	@FXML
	private Canvas center_canv;

	@FXML
	private Button square_up_button;

	@FXML
	public void initialize()
	{
		gc = center_canv.getGraphicsContext2D();

		/* set event listener for size change of boarder pane */
		my_vbox.widthProperty().addListener((observable, oldValue, newValue) ->
		{
			center_canv.widthProperty().setValue((double) newValue);
			PaintGrid();

		});

		my_vbox.heightProperty().addListener((observable, oldValue, newValue) ->
		{
			center_canv.heightProperty().setValue((double) newValue-(double)square_up_button.getHeight());
			PaintGrid();

		});

	}

	@FXML
	void ButtonOnClick(ActionEvent event)
	{
		PaintGrid();

		int ten_precent = (num_of_rows * num_of_columns) / TEN_PRECENT;
		for (int i = 0; i < ten_precent; i++)
		{
			addPoint(num_of_columns, num_of_rows);/* fill up the list of points */
		}

		drawSquares(SQAURE_SIDE_LENGTH);
	}

	/**
	 * this function fills up the square list with 10% randomly generated square
	 * coordinates
	 * 
	 * @param horizontal_lim number of squares in the horizontal plane
	 * @param vertical_lim   number of squares in the vertical plane
	 */
	void addPoint(int horizontal_lim, int vertical_lim)
	{
		Point temp = new Point(rand.nextInt(horizontal_lim), rand.nextInt(vertical_lim));// get random point
		while (PointArraySearch(temp) != null)
		{
			temp = new Point(rand.nextInt(horizontal_lim), rand.nextInt(vertical_lim));// get random point
		}
		squares.add(temp);
	}

	/**
	 * this function searches a given square in the list of squares by value
	 * 
	 * @param to_find the square to find by values in the list of squares
	 * @return found point reference if already found, null if not found
	 */
	Point PointArraySearch(Point to_find)
	{
		for (int i = 0; i < squares.size(); i++)
		{
			if (squares.get(i).getx() == to_find.getx() && squares.get(i).gety() == to_find.gety())
			{
				return squares.get(i);
			}
		}
		return null;

	}

	/**
	 * this function resets the canvas grid
	 * 
	 */
	void PaintGrid()
	{

		int canv_width = (int) center_canv.getWidth();
		int canv_height = (int) center_canv.getHeight();
		num_of_rows = 0;
		num_of_columns = 0;

		gc.clearRect(0, 0, canv_width, canv_height);
		squares.clear();
		/* setting up the grid */
		for (int i = 0; i < canv_height; i += SQAURE_SIDE_LENGTH + 1)
		{
			num_of_rows++;/* count number of rows */
			gc.strokeLine(0, i, canv_width, i);
		}
		num_of_rows--;// amount of squares=amount of rows-1

		for (int i = 0; i < canv_width; i += SQAURE_SIDE_LENGTH + 1)
		{
			num_of_columns++;/* count number of columns */
			gc.strokeLine(i, 0, i, canv_height);
		}
		num_of_columns--;// amount of horizontal squares = number of of columns -1

	}

	/**
	 * 
	 * this function draws the squares on the canvas
	 * 
	 * @param side_length is an integer holding the dimension of the squares
	 * 
	 */
	void drawSquares(int side_length)
	{
		for (int i = 0; i < squares.size(); i++)
		{
			gc.fillRect(1 + (squares.get(i).getx() * SQUARE_BOARDER), 1 + (squares.get(i).gety() * SQUARE_BOARDER), side_length, side_length);
		}
	}
}