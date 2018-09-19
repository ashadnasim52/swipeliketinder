package ashad.app.torch.flashlight.timepass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

public class MainActivity extends AppCompatActivity implements SwipeStack.SwipeStackListener{
    private ArrayList<String> mData;
    private SwipeStack mSwipeStack;
    private SwipeStackAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeStack = (SwipeStack) findViewById(R.id.swipeStack);
        mData = new ArrayList<>();
        fillWithTestData();
        mAdapter = new SwipeStackAdapter(mData);
        mSwipeStack.setAdapter(mAdapter);
        mSwipeStack.setListener(this);

    }

    private void fillWithTestData() {
        for (int x = 0; x < 555; x++) {
            mData.add("dummy_text" + " " + (x + 1));
        }
    }




    @Override
    public void onViewSwipedToLeft(int position) {

    }

    @Override
    public void onViewSwipedToRight(int position) {

    }

    @Override
    public void onStackEmpty() {

    }




    public class SwipeStackAdapter extends BaseAdapter {

        private List<String> mData;

        public SwipeStackAdapter(List<String> data) {
            this.mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
              View  view = getLayoutInflater().inflate(R.layout.card, parent, false);


            TextView textViewCard = (TextView) view.findViewById(R.id.textViewCard);
            textViewCard.setText(mData.get(position));

            return view;
        }
    }
}
