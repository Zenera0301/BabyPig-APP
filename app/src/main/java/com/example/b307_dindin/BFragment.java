package com.example.b307_dindin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class BFragment extends Fragment implements View.OnClickListener{
    private List<HKitem> hkitemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private HKitemAdapter adapter;

    public BFragment() {
        // Required empty public constructor
    }

    public static BFragment newInstance(String title){
        BFragment fragment = new BFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initItems();
        //recyclerview的初始化
        recyclerView = (RecyclerView)view.findViewById(R.id.rv_b);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        adapter = new HKitemAdapter(hkitemList);
        recyclerView.setAdapter(adapter);
    }


    private void initItems() {
        hkitemList.add(new HKitem("河卡种羊场",
                "青海省河卡种羊场始建于1953年，占地面积27.73万亩，是培育“青海毛肉兼用半细毛羊”种羊场，1999年由省畜牧厅移交给省农牧控股公司，现隶属青海省三江集团有限责任公司。",
                "2018-9-1",
                R.drawable.gate1));
        hkitemList.add(new HKitem("企业文化建设",
                "河卡种羊场每年举办“七一”党建活动，开展多项文体活动，场领导以普通职工的身份积极参与，促进了上下关系的和睦，极大地激发了职工参加文体活动的热情。表先进，树典型，通过表彰先进激励斗志，鞭策全场干部职工向被表彰的先进人物、先进事迹学习。",
                "2018-9-1",
                R.drawable.gate1));
        hkitemList.add(new HKitem("产业发展",
                "积极调整产业结构，利用成熟的技术力量和机械化程度高的优势，有效利用土地资源，抓住国家农垦改革有利政策，大力发展特高原色农牧产业。以牧草种植为重点，合理布局草产业发展格局，坚持走种植规模化、品种优良化、生产标准化、经营产业化、加工精细化的路子，努力推动农牧业健康发展，不断加大草畜转化力度，提高种草养畜的效益，逐步形成“以草养畜，以畜促草”的有机循环农牧业。",
                "2018-9-1",
                R.drawable.gate1));
        hkitemList.add(new HKitem("半细毛羊",
                "青海高原半细毛羊对严酷的高寒环境条件具有良好的适应性,对饲养管理条件的改善反应明显,公羊多有螺旋型角，母羊无角或有小角,羊毛呈明显或不明显的波状弯曲,油汗多呈白色或乳黄色.",
                "2018-9-1",
                R.drawable.gate1));
        hkitemList.add(new HKitem("研究意义",
                "自1958年起，青海省河卡种羊场场以“绵羊改良，促进畜牧业发展”为宗旨，一直从事 “青海高原毛肉兼用半细毛羊”的繁育工作，1963年由青海省人民政府和农业部批准，正式确定为培育毛肉兼用半细毛羊种羊场，在严酷的自然环境下，经过20多年几代科技工作者和职工群众艰苦努力的工作，在1987年7月成功培育出了毛肉兼用半细毛羊，各项生产性能达到了育种指标，顺利通过了省级鉴定验收，被省政府命名为“青海高原毛肉兼用半细毛羊”，荣获“青海科技进步一等奖”科技成果奖，在发展高效特色畜牧业，加快畜牧业产业化进程方面，发挥了国有种畜场的带动、示范、辐射功能。",
                "2018-9-1",
                R.drawable.gate1));
        hkitemList.add(new HKitem("生态环境",
                "积极调整产业结构，利用成熟的技术力量和机械化程度高的优势，有效利用土地资源，抓住国家农垦改革有利政策，大力发展特高原色农牧产业。以牧草种植为重点，合理布局草产业发展格局，坚持走种植规模化、品种优良化、生产标准化、经营产业化、加工精细化的路子，结合本地区“有机产品”认证的优势，进一步发展“牛羊生态健康养殖”业，同时，紧紧抓住国家加强草原生态保护的重大历史机遇，按照“合理布局、加大投入、统筹发展、提质增效”的思路，用产业化的思维和循环经济的理念谋划产业发展，努力推动农牧业健康发展，不断加大草畜转化力度，提高种草养畜的效益，逐步形成“以草养畜，以畜促草”的有机循环农牧业。",
                "2018-9-1",
                R.drawable.gate1));
        hkitemList.add(new HKitem("人文环境",
                "认真开展“两学一做”学习教育，各支部以集中学、联合学，自学的方式扎实学习习近平总书记新系列讲话精神、十九大精神及党纪党规等。牧业党支部、农业党支部开展草原田间课堂，支部书记、联点领导前往牧业草场、农业田间地头开展政策宣讲，机关党支部通过集中宣讲、座谈、讨论等形式学系列讲话、学会议精神，引导党员干部、机关工作人员以“两学一做”学习教育为载体，定期打扫思想灰尘，进行党性体检，提高自身素质与业务工作能力。",
                "2018-9-1",
                R.drawable.gate1));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步任务
    }
    @Override
    public void onClick(View v) {

    }

}
