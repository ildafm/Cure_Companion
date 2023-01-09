package com.rekom.CureCompanion;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rekom.CureCompanion.DRVinterface.UpdateRecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.StaticRVViewHolder>{

    private ArrayList<CategoryRvModel> items;
    int row_index = -1;
    UpdateRecyclerView updateRecyclerView;
    Activity activity;
    boolean check = true;
    boolean select = true;

    public CategoryAdapter(ArrayList<CategoryRvModel> items, Activity activity, UpdateRecyclerView updateRecyclerView) {
        this.items = items;
        this.activity = activity;
        this.updateRecyclerView = updateRecyclerView;
    }

    public CategoryAdapter(ArrayList<CategoryRvModel> item) {
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_rv_item,parent, false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CategoryRvModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

        if (check){

            ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
            items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",""));
            updateRecyclerView.callback(position, items);
            check = false;
        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                //injeksi
                if(position==0){
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Amplodipine", "1","Rp 47.500","Injeksi","52g","Amlodipine bermanfaat untuk menurunkan tekanan darah tinggi, membantu mencegah stroke, serangan jantung, dan masalah ginjal.",""));
                    updateRecyclerView.callback(position, items);

                }

                //kapsul
                else if(position==1){
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Bodrex", "1","Rp 6.900","kapsul","100g","Obat Sakit Kepala","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/20407/20407_1640922062.3959__540x540.jpg"));

                    items.add(new IsiCategoryRvModel("Diapet", "2","Rp 4.700","kapsul","15g","Diapet digunakan untuk membantu mengurangi frekuensi buang air besar. Tidak boleh diberikan pada anak dibawah 5 tahun dan penderita harus minum oralit.",""));

                    items.add(new IsiCategoryRvModel("Ambeven", "3","Rp 16.000","kapsul","12g","Ambeven merupakan obat dengan kandungan herbal dalam bentuk kapsul. Obat ini digunakan untuk membantu meringankan gejala wasir. Membantu meringankan gejala wasir.",""));

                    updateRecyclerView.callback(position, items);
                }

                //Krim
                else if(position==2) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
//                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",""));
                    updateRecyclerView.callback(position, items);
                }

                //liquid
                else if(position==3) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
//                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",""));
                    updateRecyclerView.callback(position, items);
                }

                //Obat Tetes
                else if(position==4) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Insto", "1","Rp 13.000","Obat tetes","7,5ml","Mengatasi kemerahan dan rasa perih pada mata yang disebabkan oleh iritasi ringan karena debu, asap, angin, dan sesudah berenang.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/22192/22192_1638437464.9416__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Serambi Botani", "2","Rp 245.000","Obat tetes","946ml","Membantu mengobati dan Mencegah penyakit KOLESTEROL, Membantu mengobati dan Mencegah ASAM URAT,Membantu pencernaan dan keseimbangan pH  ","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/25749/25749_1650727684.4__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Betadine", "3","Rp 12.000","Obat tetes","15ml","Obat yang berfungsi sebagai antiseptik pada luka untuk membunuh kuman penyebab infeksi","https://s4.bukalapak.com/img/4100692772/s-1000-1000/Betadine_solution_15_ml_15ml_betadin_antiseptik_15ml.jpg"));
                    updateRecyclerView.callback(position, items);
                }

                //Salep
                else if(position==5) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Zam-Buk", "1","Rp 15.000","salep","25gr","membantu meredakan memar dan terkilir ringan, gatal akibat gigitan serangga dan nyamuk, serta membantu meredakan rasa nyeri dan gatal-gatal yang berkaitan dengan luka ringan.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/15126/15126_1625195355.0662__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Kalpanax", "2","Rp 7.000","salep","6gr","mengatasi jamur di kulit seperti panu, kadas, kurap, kutu air hingga ruam popok.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/23373/23373_1667542352.1843__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Ichtiyol", "3","Rp 8.000","salep","15gr","Obat salep ini berfungsi sebagai antiseptik untuk mengatasi penyakit bisul. Tak hanya bersifat antibakteri dan antijamur, tetapi juga antiperadangan.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/29268/29268_1667546613.7636__540x540.jpg"));
                    updateRecyclerView.callback(position, items);

                }

                //Serbuk
                else if(position==6) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Herocyn", "1","Rp 10.000","serbuk","85gr","mengatasi masalah kulit pada keluarga. Beberapa masalah kulit ini diantaranya adalah biang keringat, gatal-gatal dan iritasi.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/20025/20025_1642390404.6525__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Thebalis", "2","Rp 56.000","serbuk","90gr","TheBalis ialah suplemen kesehatan untuk meningkatkan stamina.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/33627/33627_1667808445.4496__540x540.JPG"));
                    items.add(new IsiCategoryRvModel("Hemaviton", "3","Rp 5000","serbuk","3gr","Minuman supplemen bervitamin dalam bentuk serbuk yang menyegarkan untuk menjaga stamina pada saat berolahraga dan bekerja keras.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/15736/15736_1630058551.0287__540x540.jpg"));
                    updateRecyclerView.callback(position, items);
                }

                //Sirup
                else if(position==7) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Vicks", "1","Rp.10.000","sirup","27ml","Obat demam","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/12387/12387_1635407296.27__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Combi", "2","Rp.14.100","sirup","100ml","Obat batuk berdahak","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/12314/12314_1639556448.8993__540x540.jpg"));
                    items.add(new IsiCategoryRvModel("Tempra Forte Jeruk", "3","Rp.52.000","sirup","60ml","Obat untuk meringankan rasa sakit seperti sakit gigi, sakit kepala, dan menurunkan demam.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/10644/10644_1662649752.6042__540x540.jpg"));


                    updateRecyclerView.callback(position, items);
                }

                //Tablet
                else if(position==8) {

                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
//                    items.add(new IsiCategoryRvModel("kapsul", "Rp12.000","dss","sss","ssss","sssss",""));
                    updateRecyclerView.callback(position, items);

                }
            }
        });

        if(select){
            if(position==0)
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            select=false;
        }
        else{
            if (row_index == position){
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected_bg);
            }
            else {
                holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_item_category);
            textView = itemView.findViewById(R.id.tv_item_category);
            linearLayout = itemView.findViewById(R.id.linearlayout);
        }
    }
}
