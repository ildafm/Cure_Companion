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

            items.add(new IsiCategoryRvModel("Streptomycin", "1","Rp 47.500","52g","Streptomycin adalah obat antibiotik untuk mengatasi tuberkulosis dan penyakit infeksi bakteri lain, seperti tularemia, endokarditis bakteri, pes (plague), brucellosis, meningitis, pneumonia, atau infeksi saluran kemih.","https://storage.googleapis.com/rxstorage/Product/large/Apotek_Online_Farmaku_com_Streptomycin_Sulfate_Meiji.jpg"));

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

                    items.add(new IsiCategoryRvModel("Streptomycin", "1","Rp 47.500","52g","Streptomycin adalah obat antibiotik untuk mengatasi tuberkulosis dan penyakit infeksi bakteri lain, seperti tularemia, endokarditis bakteri, pes (plague), brucellosis, meningitis, pneumonia, atau infeksi saluran kemih.","https://storage.googleapis.com/rxstorage/Product/large/Apotek_Online_Farmaku_com_Streptomycin_Sulfate_Meiji.jpg"));

                    items.add(new IsiCategoryRvModel("Vaksin Influenza", "2","Rp 397.500","10g","Vaksin influenza merupakan vaksin yang mampu melindungi Anda dari penyakit flu. Vaksin ini sebaiknya diberikan setiap satu tahun sekali. Meski merupakan penyakit ringan, flu nyatanya juga bisa menimbulkan masalah besar bagi sebagian orang.","https://cdn.hellosehat.com/2019/07/jenis-vaksin-influenza.jpg"));

                    items.add(new IsiCategoryRvModel("Penicillin G Procaine", "3","","","Penicillin G procaine atau procaine benzylpenicillin adalah obat antibiotik untuk menangani infeksi bakteri, seperti anthrax, sifilis, atau infeksi Streptococcus beta-hemolitik grup A, atau infeksi Staphylococcus.","https://storage.googleapis.com/rxstorage/Product/large/Apotek_Online_Farmaku_com_Penicillin-G_PPC.jpg"));


                    updateRecyclerView.callback(position, items);

                }

                //kapsul
                else if(position==1){
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();
                    items.add(new IsiCategoryRvModel("Diapet", "1","Rp 4.700","15g","Diapet digunakan untuk membantu mengurangi frekuensi buang air besar. Tidak boleh diberikan pada anak dibawah 5 tahun dan penderita harus minum oralit.", "https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/22203/22203_1639731900.0222__540x540.jpg"));

                    items.add(new IsiCategoryRvModel("Ambeven", "2","Rp 16.000","12g","Ambeven merupakan obat dengan kandungan herbal dalam bentuk kapsul. Obat ini digunakan untuk membantu meringankan gejala wasir. Membantu meringankan gejala wasir.", "https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/20393/20393_1639636173.1324__540x540.jpg"));

                    items.add(new IsiCategoryRvModel("Alaxan FR", "3","Rp 16.000","12g","ALAXAN FR 10 KAPSUL adalah Kapsul Fast Release (FR) yang bekerja cepat untuk meredakan nyeri otot di leher, pundak, punggung, sakit pinggang, paha dan kaki, serta nyeri haid dan sakit gigi", "https://cdn.shopify.com/s/files/1/0479/7068/0981/products/df9cdb9652fd4e95e476d17ebf2fb180_1_1024x1024@2x.jpg"));

                    updateRecyclerView.callback(position, items);
                }

                //Krim
                else if(position==2) {
                    ArrayList<IsiCategoryRvModel> items = new ArrayList<IsiCategoryRvModel>();

                    items.add(new IsiCategoryRvModel("Fungiderm", "1","Rp30.000","250g","Fungiderm cream digunakan untuk mengatasi dermatomikosis atau infeksi kulit akibat jamur seperti gatal, kutu air, panu, infeksi jamur di kulit kepala, kurap,kandidiasis pada kulit dan kuku.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/10817/10817_1618558569.166__540x540.jpg"));

                    items.add(new IsiCategoryRvModel("Daktarin", "2","Rp30.000","200g","Daktarin cream merupakan sediaan topikal atau Krim Anti Jamur yang tiap gram mengandung zat aktif Miconazole Nitrat 20 mg.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/10779/10779_1618822091.2184__540x540.jpg"));

                    items.add(new IsiCategoryRvModel("Canesten", "3","Rp45.000","19g","Canesten cream adalah krim yang mengandung Clotrimazole. Obat ini digunakan untuk mengatasi jamur pada kulit, panu, kadas/kurap, kutu air, dan ruam popok.","https://kalcare.s3-ap-southeast-1.amazonaws.com/moch4/uploads/product/23543/23543_1649042726.1487__540x540.jpg"));

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

                    items.add(new IsiCategoryRvModel("Bodrex", "1","Rp 9.118","100g","Obat sakit kepala, sakit gigi, nyeri otot, demam yang berkaitan dengan flu dan masuk angin.", "https://images.tokopedia.net/img/cache/900/product-1/2019/2/1/12048559/12048559_3767017d-81a8-4d59-a6ba-6304b9878bd1_600_600.jpg"));

                    items.add(new IsiCategoryRvModel("Mylanta", "2","Rp 20.372","200g","Obat ini digunakan untuk mengurangi gejala-gejala yang berhubungan dengan kelebihan asam lambung, gastritis, tukak lambung, tukak usus 12 jari, dengan gejala-gejala seperti mual, nyeri lambung, nyeri ulu hati.", "https://images.tokopedia.net/img/cache/900/VqbcmM/2022/7/20/7dc72b0b-7daf-42ee-8c71-9a006d05b0d1.jpg"));

                    items.add(new IsiCategoryRvModel("Promag", "3","Rp 7.600","50g","Promag merupakan obat dengan kandungan Hydrotalcite, Mg(OH)2, Simethicone dalam bentuk tablet. Obat ini digunakan untuk mengurangi gejala-gejala yang berhubungan dengan kelebihan asam lambung, gastritis, tukak lambung, tukak usus 12 jari.", "https://images.tokopedia.net/img/cache/900/VqbcmM/2022/1/14/0c835d9a-9904-444d-b155-0af4385534f3.jpg"));


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
