package tieorange.com.productivereader;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonthFragment extends Fragment {


    private BarChart mUiBarChart;
    private View mView;
    Random random = new Random();

    public MonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_month, container, false);
        // Inflate the layout for this fragment


        setupBarChart();
        return mView;
    }

    public static MonthFragment newInstance(String param1, String param2) {
        MonthFragment fragment = new MonthFragment();
        return fragment;
    }

    private void setupBarChart() {
        // create dataset:
        mUiBarChart = (BarChart) mView.findViewById(R.id.month_bar_chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            int pagesCount = random.nextInt(50);
            entries.add(new BarEntry(pagesCount, i));

            // Defining the X-Axis Labels
            labels.add(String.valueOf(i+1));
        }
        BarDataSet barDataSet = new BarDataSet(entries, "Прочитав сторінок за день");
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);

        BarData barData = new BarData(labels, barDataSet);
        mUiBarChart.setData(barData);
        mUiBarChart.setDescription("Скільки ти читаєш за місяць?");
        mUiBarChart.animateXY(5000, 5000);


        mUiBarChart.invalidate(); // refresh
    }


}
