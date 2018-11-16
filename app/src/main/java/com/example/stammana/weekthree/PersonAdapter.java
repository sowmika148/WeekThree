package com.example.stammana.weekthree;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stammana.weekthree.model.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private List<Person> persons;

    public PersonAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View foodItemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_person_name, parent, false);
        return new PersonViewHolder(foodItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        String toDoItem = persons.get(position).getFirstName();
        holder.personNameView.setText(toDoItem);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView personNameView;

        public PersonViewHolder(View foodItemView) {
            super(foodItemView);
            personNameView = itemView.findViewById(R.id.person_name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Context context = view.getContext();
            Intent intent = new Intent(context.getApplicationContext(), PersonActivity.class);
            intent.putExtra("person", persons.get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }
}
