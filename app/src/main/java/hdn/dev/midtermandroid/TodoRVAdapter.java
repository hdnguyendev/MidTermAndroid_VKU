package hdn.dev.midtermandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoRVAdapter extends RecyclerView.Adapter<TodoRVAdapter.ViewHolder> {
    private List<Todo> todos;

    public TodoRVAdapter(List<Todo> todos) {
        this.todos = todos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.titleTextView.setText("User ID: " + todo.getUserId() + ", ID: " + todo.getId() + ", Title: " + todo.getTitle());
        holder.completedCheckBox.setChecked(todo.isCompleted());
        holder.completedCheckBox.setEnabled(false);
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public CheckBox completedCheckBox;

        public ViewHolder(View view) {
            super(view);
            titleTextView = view.findViewById(R.id.titleTextView);
            completedCheckBox = view.findViewById(R.id.completedCheckBox);
        }
    }
}