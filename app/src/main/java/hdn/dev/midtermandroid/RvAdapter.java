package hdn.dev.midtermandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ContactViewHolder> {
    private ArrayList<Contact> list;
    private Context context;

    public RvAdapter(ArrayList<Contact> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = list.get(position);
        holder.tvName.setText("ID: " + contact.getId() + ", Name: " + contact.getName());
        holder.tvPhone.setText("Phone Number: " + contact.getPhone());
        holder.tvEmail.setText("Email Address: " +contact.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName, tvPhone, tvEmail;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            // init
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvEmail = itemView.findViewById(R.id.tv_email);
        }
    }
}
